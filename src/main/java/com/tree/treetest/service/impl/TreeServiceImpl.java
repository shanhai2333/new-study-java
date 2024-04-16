package com.tree.treetest.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tree.common.response.Result;
import com.tree.treetest.domain.TreeTable;
import com.tree.treetest.mapper.TreeTableMapper;
import com.tree.treetest.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class TreeServiceImpl implements TreeService {
    @Autowired
    private TreeTableMapper treeTableMapper;
    @Override
    public List<TreeTable> getData() {
        // 查询所有菜单
        List<TreeTable> treeTableList = new TreeTable().selectAll();
        // 转换为map
        Map<Integer,TreeTable> map = treeTableList.stream().collect(Collectors.toMap(TreeTable::getId, treeTable -> treeTable));
        // 过滤最顶层菜单
        List<TreeTable> top = treeTableList.stream().filter(treeTable -> ObjectUtils.isEmpty(treeTable.getParentId())).toList();
        // 过滤非顶层
        List<TreeTable> child = treeTableList.stream().filter(treeTable -> !ObjectUtils.isEmpty(treeTable.getParentId())).toList();

        // 定义返回结果
        List<TreeTable> tree = new ArrayList<>();

        // 判断非顶层是否为空
        if (!CollectionUtils.isEmpty(child)) {
            // 遍历非顶层
            for (TreeTable treeTable : child) {
                TreeTable parent = map.get(treeTable.getParentId());
                if (!ObjectUtils.isEmpty(parent)) {
                    if (ObjectUtils.isEmpty(parent.getChildren())) {
                        parent.setChildren(new ArrayList<>());
                    }
                    parent.getChildren().add(treeTable);
                }
            }
        }
        // 遍历顶层
        if (!CollectionUtils.isEmpty(top)) {
            for (TreeTable treeTable : top) {
                TreeTable parent = map.get(treeTable.getId());
                if (ObjectUtils.isEmpty(parent.getParentId())) {
                    tree.add(parent);
                }
            }
        }
        return tree;
    }

    @Override
    public Result<Object> addData(Integer id , JSONObject jsonObject , String name , String parentId) {
        TreeTable treeTable = new TreeTable();
        treeTable.setId(id);
        treeTable.setDate(jsonObject);
        treeTable.setLabel(name);
        treeTable.setLabel(parentId);
        int result = treeTableMapper.insert(treeTable);
        if (result==1){
            return Result.ok();
        }else {
            return Result.failure("新建失败请联系管理员");
        }
    }

    @Override
    public Result<Object> deleteData(Integer id) {
        TreeTable treeTable = new TreeTable().selectById(id);
        int result = treeTableMapper.deleteById(treeTable);
        if (result==1){
            return Result.ok();
        }else {
            return Result.failure("删除失败请联系管理员");
        }
    }

    @Override
    public Result<Object> updateData(Integer id , JSONObject jsonObject , String name) {

        TreeTable treeTable = new TreeTable().selectById(id);
        treeTable.setDate(jsonObject);
        treeTable.setLabel(name);
        int result = treeTableMapper.updateById(treeTable);
        if (result==1){
            return Result.ok();
        }else {
            return Result.failure("插入失败请联系管理员");
        }
    }

    @Override
    public List<TreeTable> getByName(String name) {
        List<TreeTable> treeTableList = new TreeTable().selectList(Wrappers.<TreeTable>lambdaQuery().like(TreeTable::getLabel, name));
        // 过滤最顶层菜单
        List<TreeTable> top = treeTableList.stream().filter(treeTable -> ObjectUtils.isEmpty(treeTable.getParentId())).toList();
        // 过滤非顶层
        List<TreeTable> child = treeTableList.stream().filter(treeTable -> !ObjectUtils.isEmpty(treeTable.getParentId())).toList();

        // 查询非顶级菜单的父级菜单
        if (!CollectionUtils.isEmpty(child)) {
            List<TreeTable> parentList = new TreeTable().selectList(Wrappers.<TreeTable>lambdaQuery()
                    .in(TreeTable::getId, child.stream().map(TreeTable::getParentId).toList()));
            List<TreeTable> parentVo = parentList.stream().filter(treeTable -> ObjectUtils.isEmpty(treeTable.getParentId())).toList();
            // 将父级菜单添加到菜单集合中
            if (!CollectionUtils.isEmpty(parentVo)) {
                top = new ArrayList<>(top);
                top.addAll(parentVo);
                List<TreeTable> childMap = parentList.stream().filter(treeTable -> !ObjectUtils.isEmpty(treeTable.getParentId())).toList();
                if (!CollectionUtils.isEmpty(childMap)) {
                    List<TreeTable> parentList2 = new TreeTable().selectList(Wrappers.<TreeTable>lambdaQuery()
                            .in(TreeTable::getId, childMap.stream().map(TreeTable::getParentId).toList()));
                    List<TreeTable> parentVo2 = parentList2.stream().toList();
                    top.addAll(parentVo2);
                }
            }
        }
        // 顶级菜单去重
        top = top.stream().distinct().toList();
        // 子级菜单去重
        child = child.stream().distinct().toList();
        // 递归
        for (TreeTable vo : child) {
            getMenuChildren(child, vo);
        }

        for (TreeTable vo : top) {
            getMenuChildren(child, vo);
        }
        return top;
    }

    private void getMenuChildren(List<TreeTable> child, TreeTable vo) {
        List<TreeTable> children = child.stream().filter(treeTable -> treeTable.getParentId().equals(vo.getId())).toList();
        if (!CollectionUtils.isEmpty(children)) {
            vo.setChildren(children);
            for (TreeTable child1 : children) {
                getMenuChildren(child, child1);
            }
        }
    }
}
