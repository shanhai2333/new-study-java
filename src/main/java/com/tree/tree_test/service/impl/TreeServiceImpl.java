package com.tree.tree_test.service.impl;

import com.tree.tree_test.domain.TreeTable;
import com.tree.tree_test.mapper.TreeTableMapper;
import com.tree.tree_test.service.TreeService;
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
    public List<TreeTable> getAll() {
        // 查询所有菜单
        List<TreeTable> treeTableList = new TreeTable().selectAll();
        // 转换为map
        Map<Integer,TreeTable> map = treeTableList.stream().collect(Collectors.toMap(TreeTable::getId, treeTable -> treeTable));
        // 过滤最顶层菜单
        List<TreeTable> top = treeTableList.stream().filter(treeTable -> ObjectUtils.isEmpty(treeTable.getParentId())).toList();
        // 过滤非顶层
        List<TreeTable> child = treeTableList.stream().filter(treeTable -> !ObjectUtils.isEmpty(treeTable.getParentId())).toList();

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
                if (!ObjectUtils.isEmpty(parent)) {
                    tree.add(parent);
                }
            }
        }
        return tree;
    }
}
