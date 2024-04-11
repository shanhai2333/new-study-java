package com.tree.treetest.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.tree.treetest.domain.TreeTable;
import com.tree.treetest.mapper.TreeTableMapper;
import com.tree.treetest.service.UpdateTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateTreeTreeServiceImpl implements UpdateTreeService {

    @Autowired
    private TreeTableMapper treeTableMapper;
    @Override
    public String UpdateTree(Integer id , JSONObject jsonObject) {
        TreeTable treeTable = new TreeTable().selectById(id);
        treeTable.setDate(jsonObject);
        return null;
    }
}
