package org;

import org.junit.jupiter.api.Test;
import org.sboot.App;
import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest 默认先从org包下找配置类(具有@SpringBootConfiguration)
@SpringBootTest(classes = App.class)
public class OtherTest {

    @Test
    void test1() {
        System.out.println(11);
    }
}
