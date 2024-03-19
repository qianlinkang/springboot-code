package org.sboot.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.sboot.domain.LoginUser;
import org.sboot.domain.User;
import org.sboot.mapper.MenuMapper;
import org.sboot.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 实现UserDetailsService
 * 重写loadUserByUsername
 * 根据用户名从数据库中查询用户信息
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查询用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(wrapper);
        // 无,抛出异常
        if (Objects.isNull(user)) throw new RuntimeException("用户名或密码错误");
        // 查询权限信息
        List<String> permsList = menuMapper.selectPermsByUserId(user.getId());
//        List<String> list = new ArrayList<>(Arrays.asList("test", "admin"));

        // 封装成UserDetails对象返回
        return new LoginUser(user, permsList);
    }


}
