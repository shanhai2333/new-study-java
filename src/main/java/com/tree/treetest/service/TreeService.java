package com.tree.treetest.service;

import com.alibaba.fastjson2.JSONObject;
import com.tree.common.response.Result;
import com.tree.treetest.domain.TreeTable;

import java.util.List;

public interface TreeService {
    List<TreeTable> getData();

    Result<Object> addData(Integer id , JSONObject jsonObject , String name , String parentId);

    Result<Object> deleteData(Integer id);

    Result<Object> updateData(Integer id , JSONObject jsonObject , String name);
}
