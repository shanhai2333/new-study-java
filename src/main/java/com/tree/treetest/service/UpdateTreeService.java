package com.tree.treetest.service;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface UpdateTreeService {
    String UpdateTree(Integer id , JSONObject jsonObject);
}
