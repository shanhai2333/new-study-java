package com.tree.treetest.dto;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shanhai
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertDTO {
    private String name;

    private Integer parentId;

    private JSONArray data_json;
}