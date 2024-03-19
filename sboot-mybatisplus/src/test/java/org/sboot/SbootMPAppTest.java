package org.sboot;

import org.junit.jupiter.api.Test;
import org.sboot.dao.DeptMapper;
import org.sboot.domian.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SbootMPAppTest {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    void testMP() {
        Dept dept = deptMapper.selectById(2L);
        System.out.println("dept = " + dept);
    }
}