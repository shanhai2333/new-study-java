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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping("/getAll")
    public Result<List<TreeTable>> getAll(){
        return Result.ok(treeService.getAll());
    }
    @RequestMapping("/insert")
    public Result<Void> insert(Integer id , JSONObject jsonObject , String name , String parentId){

        return Result.ok(String.valueOf(addTreeService.Add(id,jsonObject,name,parentId)));
    }
    @RequestMapping("/del")
    public Result<Void> del(Integer id){

        return Result.ok(String.valueOf(deleteTreeService.Delete(id)));
    }
    @RequestMapping("/update")
    public Result<Void> update(Integer id , JSONObject jsonObject , String name){

        return Result.ok(String.valueOf(updateTreeService.Update(id,jsonObject,name)));
    }
}
