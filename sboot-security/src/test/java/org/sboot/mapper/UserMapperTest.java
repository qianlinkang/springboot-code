package org.sboot.mapper;

import org.junit.jupiter.api.Test;
import org.sboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Test
    void testUserMapper() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void testBCryptPasswordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("1234");
        System.out.println("encode = " + encode);

//        boolean flag = encoder.matches("1234", "$2a$10$DTdvZ5vTCPOaKFliNgx.aOPPeytHdw.a7C8LL/8bEyJfR/fi3LRK2");
//        System.out.println("flag = " + flag);
    }

    @Test
    void testSelectPermsByUserId() {
        System.out.println(menuMapper.selectPermsByUserId(3L));
    }
}