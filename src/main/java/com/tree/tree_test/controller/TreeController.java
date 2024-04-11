package com.tree.tree_test.controller;

import com.tree.tree_test.domain.TreeTable;
import com.tree.tree_test.service.TreeService;
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
    public List<TreeTable> getAll(){
        return treeService.getAll();
    }
    @RequestMapping("/insert")
    public void insert(){

    }
    @RequestMapping("/del")
    public void del(){

    }
    @RequestMapping("/update")
    public void update(){

    }
}
