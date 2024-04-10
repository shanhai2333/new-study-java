package com.tree.tree_test.service.impl;

import com.tree.tree_test.domain.TreeTable;
import com.tree.tree_test.mapper.TreeTableMapper;
import com.tree.tree_test.service.GetTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class GetTreeServiceImpl implements GetTreeService {
    @Autowired
    private TreeTableMapper treeTableMapper;
    @Override
    public List<TreeTable> GetAll() {
        List<TreeTable> treeTableList = treeTableMapper.selectList(null);

        List<Integer> menusIds = treeTableList.stream().map(TreeTable::getId).toList();
        // 过滤最顶层菜单
        List<TreeTable> top = treeTableList.stream().filter(treeTable -> ObjectUtils.isEmpty(treeTable.getParentId())).toList();
        // 过滤非顶层
        List<TreeTable> child = treeTableList.stream().filter(treeTable -> !ObjectUtils.isEmpty(treeTable.getParentId())).toList();

        // 判断非顶层是否为空
        if (!CollectionUtils.isEmpty(child)) {
            child.forEach(treeTable -> {

            });
        }



        return treeTableList;
    }
}
