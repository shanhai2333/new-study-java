package com.tree.treetest.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.tree.common.response.Result;
import com.tree.treetest.domain.TreeTable;
import com.tree.treetest.mapper.TreeTableMapper;
import com.tree.treetest.service.UpdateTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateTreeServiceImpl implements UpdateTreeService {

    @Autowired
    private TreeTableMapper treeTableMapper;
    @Override
    public Result<Object> Update(Integer id , JSONObject jsonObject , String name) {

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
}
