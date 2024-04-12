package com.tree.treetest.service;

import com.tree.common.response.Result;
import org.springframework.stereotype.Service;

@Service
public interface DeleteTreeService {
    Result<Object> Delete(Integer id);
}
