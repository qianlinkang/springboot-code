package org.sboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.sboot.domian.Dept;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
}
