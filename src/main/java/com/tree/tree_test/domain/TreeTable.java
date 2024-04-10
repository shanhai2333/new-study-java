package com.tree.tree_test.domain;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "tree")
public class TreeTable {
    @TableId("id")
    private int id;
    @TableField("label")
    private String label;
    @TableField("date")
    private JSONObject date;
    @TableField("parent_id")
    private String parentId;
    @TableField(exist = false)
    private List<TreeTable> children;

}
