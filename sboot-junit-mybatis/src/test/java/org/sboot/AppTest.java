package org.sboot;


import org.junit.jupiter.api.Test;
import org.sboot.dao.DeptMapper;
import org.sboot.domian.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
@SpringBootTest
class AppTest {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    void testApp() {
        assertTrue(true);
    }

    @Test
    void testMybatis() {
        Dept dept = deptMapper.getById(1);
        System.out.println("dept = " + dept);
    }

}
