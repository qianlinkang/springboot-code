package org.sboot.buildsboot;

import org.junit.jupiter.api.Test;
import org.sboot.buildsboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuildSBootApplicationTest {

    @Autowired
    private User user;

//    @Autowired
//    private DruidDataSource dataSource;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoad() {
        System.out.println("test...");
    }

    @Test
    void testUser() {
        System.out.println(user.getName());
        System.out.println(user.getPassword());
    }

    @Test
    void testDruidDataSource() {
        System.out.println(dataSource);
    }

}