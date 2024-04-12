package com.tree.treetest.service;

import com.alibaba.fastjson2.JSONObject;
import com.tree.common.response.Result;
import org.springframework.stereotype.Service;

@Service
public interface UpdateTreeService {
    Result<Object> Update(Integer id , JSONObject jsonObject , String name);
}
