package org.sboot.ssmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.sboot.ssmp.domain.Book;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}

