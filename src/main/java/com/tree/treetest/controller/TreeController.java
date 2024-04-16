package com.tree.treetest.controller;

import com.alibaba.fastjson2.JSONObject;
import com.tree.common.response.Result;
import com.tree.treetest.domain.TreeTable;
import com.tree.treetest.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tree")
public class TreeController {

    @Autowired
    private TreeService treeService;
    @GetMapping("/getAll")
    public Result<List<TreeTable>> getAll(){
        List<TreeTable> treeTables = treeService.getData();
        return Result.ok(treeTables);
    }
    @GetMapping("/insert")
    public Result<Void> insert(Integer id , JSONObject jsonObject , String name , String parentId){

        return Result.ok(String.valueOf(treeService.addData(id,jsonObject,name,parentId)));
    }
    @GetMapping("/del")
    public Result<Void> del(Integer id){

        return Result.ok(String.valueOf(treeService.deleteData(id)));
    }
    @GetMapping("/update")
    public Result<Void> update(Integer id , JSONObject jsonObject , String name){

        return Result.ok(String.valueOf(treeService.updateData(id,jsonObject,name)));
    }
}
