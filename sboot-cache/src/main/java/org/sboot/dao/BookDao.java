package org.sboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.sboot.domain.Book;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}
