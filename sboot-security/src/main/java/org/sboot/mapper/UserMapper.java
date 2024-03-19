package org.sboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.sboot.domain.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}