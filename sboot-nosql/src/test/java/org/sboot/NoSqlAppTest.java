package org.sboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoSqlAppTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testSet() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("age", 41);
    }

    @Test
    void testGet() {
        ValueOperations ops = redisTemplate.opsForValue();
        Object o = ops.get("age");
        System.out.println("o = " + o);
    }

    @Test
    void testHSet() {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("info", "a", "aaa");
    }

    @Test
    void testHGet() {
        HashOperations hashOperations = redisTemplate.opsForHash();
        Object o = hashOperations.get("info", "a");
        System.out.println("o = " + o);

    }

}