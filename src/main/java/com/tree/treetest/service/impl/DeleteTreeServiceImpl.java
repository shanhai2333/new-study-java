package com.tree.treetest.service.impl;

import com.tree.common.response.Result;
import com.tree.treetest.domain.TreeTable;
import com.tree.treetest.mapper.TreeTableMapper;
import com.tree.treetest.service.DeleteTreeService;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteTreeServiceImpl implements DeleteTreeService {
    @Autowired
    private TreeTableMapper treeTableMapper;
    @Override
    public Result<Object> Delete(Integer id) {
        TreeTable treeTable = new TreeTable().selectById(id);
        int result = treeTableMapper.deleteById(treeTable);
        if (result==1){
            return Result.ok();
        }else {
            return Result.failure("删除失败请联系管理员");
        }
    }
}
