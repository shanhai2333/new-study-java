package com.tree.treetest.controller;

import com.alibaba.fastjson2.JSONObject;
import com.tree.common.response.Result;
import com.tree.treetest.domain.TreeTable;
import com.tree.treetest.dto.GetByNameDTO;
import com.tree.treetest.dto.InsertDTO;
import com.tree.treetest.dto.UpDateDTO;
import com.tree.treetest.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tree")
@CrossOrigin
public class TreeController {

    @Autowired
    private TreeService treeService;
    @GetMapping("/getAll")
    public Result<List<TreeTable>> getAll(){
        return Result.ok(treeService.getData());
    }

    @PostMapping("/getByName")
    public Result<List<TreeTable>> getByName(@RequestBody GetByNameDTO dto){
        return Result.ok(treeService.getByName(dto.getName()));
    }

    @PostMapping("/insert")
    public Result<Object> insert(@RequestBody InsertDTO dto){
        return Result.ok(treeService.addData(dto));
    }
    @PostMapping("/del")
    public Result<Object> del(Integer id){
        return Result.ok(treeService.deleteData(id));
    }
    @PostMapping("/update")
    public Result<Object> update(@RequestBody UpDateDTO dto){

        return Result.ok(treeService.updateData(dto));
    }
}
