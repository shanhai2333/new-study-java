package com.tree.treetest.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.tree.common.response.Result;
import com.tree.treetest.domain.TreeTable;
import com.tree.treetest.mapper.TreeTableMapper;
import com.tree.treetest.service.AddTreeService;
import org.springframework.beans.factory.annotation.Autowired;

public class AddTreeServiceImpl implements AddTreeService {
    @Autowired
    private TreeTableMapper treeTableMapper;
    @Override
    public Result<Object> Add(Integer id , JSONObject jsonObject , String name , String parentId) {
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
}
