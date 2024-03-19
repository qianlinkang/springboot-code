package org.sboot;

import org.junit.jupiter.api.Test;
import org.sboot.buildsboot.BuildSBootApplication;
import org.sboot.buildsboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

// 约定大于配置
//@SpringBootTest(classes = BuildSBootApplication.class)
@SpringBootTest
@ContextConfiguration(classes = BuildSBootApplication.class)
public class OuterTest {
    @Autowired
    private User user;

    @Test
    void contextLoad() {
        System.out.println("test...");
    }

    @Test
    void testUser() {
        System.out.println(user.getName());
        System.out.println(user.getPassword());
    }
}
