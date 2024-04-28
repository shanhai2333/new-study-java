package com.tree.treetest.service;

import com.alibaba.fastjson2.JSONObject;
import com.tree.common.response.Result;
import com.tree.treetest.domain.TreeTable;
import com.tree.treetest.dto.InsertDTO;
import com.tree.treetest.dto.UpDateDTO;

import java.util.List;

public interface TreeService {
    List<TreeTable> getData();

    Result<Object> addData(InsertDTO dto);

    Result<Object> deleteData(Integer id);
    Result<Object> selectData(Integer id);
    Result<Object> updateData(UpDateDTO dto);

    List<TreeTable> getByName(String name);
}
