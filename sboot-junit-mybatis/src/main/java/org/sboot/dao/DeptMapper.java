package org.sboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.sboot.domian.Dept;

@Mapper
public interface DeptMapper {

    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);
}
