package com.tree.treetest.controller;

import com.tree.common.response.Result;
import com.tree.treetest.domain.TreeTable;
import com.tree.treetest.service.TreeService;
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
    @RequestMapping("/getAll")
    public Result<List<TreeTable>> getAll(){
        return Result.ok(treeService.getAll());
    }
    @RequestMapping("/insert")
    public Result<Void> insert(){

        return Result.ok();
    }
    @RequestMapping("/del")
    public Result<Void> del(){

        return Result.ok();
    }
    @RequestMapping("/update")
    public Result<Void> update(){

        return Result.ok();
    }
}
