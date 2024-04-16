package com.tree.treetest.controller;

import com.alibaba.fastjson2.JSONObject;
import com.tree.common.response.Result;
import com.tree.treetest.domain.TreeTable;
import com.tree.treetest.service.AddTreeService;
import com.tree.treetest.service.DeleteTreeService;
import com.tree.treetest.service.TreeService;
import com.tree.treetest.service.UpdateTreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tree")
@ResponseBody
@RequiredArgsConstructor
public class TreeController {

    private final TreeService treeService;
    private final AddTreeService addTreeService;
    private final DeleteTreeService deleteTreeService;
    private final UpdateTreeService updateTreeService;
    @GetMapping("/getAll")
    public Result<List<TreeTable>> getAll(){
        return Result.ok(treeService.getAll());
    }
    @PostMapping("/insert")
    public Result<Void> insert(Integer id , JSONObject jsonObject , String name , String parentId){

        return Result.ok(String.valueOf(addTreeService.Add(id,jsonObject,name,parentId)));
    }
    @DeleteMapping("/del")
    public Result<Void> del(Integer id){

        return Result.ok(String.valueOf(deleteTreeService.Delete(id)));
    }
    @PutMapping("/update")
    public Result<Void> update(Integer id , JSONObject jsonObject , String name){

        return Result.ok(String.valueOf(updateTreeService.Update(id,jsonObject,name)));
    }
}
