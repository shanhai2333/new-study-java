package com.tree.tree_test.domain;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "tree")
public class TreeTable extends Model<TreeTable> {
    @TableId("id")
    private Integer id;
    @TableField("label")
    private String label;
    @TableField("date")
    private JSONObject date;
    @TableField("parent_id")
    private Integer parentId;
    @TableField(exist = false)
    private List<TreeTable> children;

}
