package com.tree.treetest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tree.treetest.domain.TreeTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TreeTableMapper extends BaseMapper<TreeTable> {
}
