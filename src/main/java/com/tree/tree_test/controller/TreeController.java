package com.tree.tree_test.controller;

import com.tree.tree_test.domain.TreeTable;
import com.tree.tree_test.service.GetTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tree")
@ResponseBody
public class TreeController {
    @Autowired
    @Qualifier("getTreeServiceImpl")
    private GetTreeService getTreeService;
    @RequestMapping("/GetAll")
    public List<TreeTable> GetAll(){
        List<TreeTable> getAll = getTreeService.GetAll();

        return getAll;
    }
    @RequestMapping("/Insert")
    public void Insert(){

    }
    @RequestMapping("/Del")
    public void Del(){

    }
    @RequestMapping("/Update")
    public void Update(){

    }
}
