package com.tree.tree_test.service.impl;

import com.tree.tree_test.mapper.TreeTableMapper;
import com.tree.tree_test.service.UpdateTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateTreeTreeServiceImpl implements UpdateTreeService {

    @Autowired
    private TreeTableMapper treeTableMapper;
    @Override
    public String UpdateTree() {

        return null;
    }
}
