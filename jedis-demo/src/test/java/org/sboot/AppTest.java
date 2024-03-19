package org.sboot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sboot.pool.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private Jedis jedis;

    @BeforeEach
    void setUp() {
//        jedis = new Jedis("192.168.39.10", 6379);

        // 使用jedisPool
        jedis = JedisConnectionFactory.getJedis();
        jedis.select(0);
    }

    @Test
    void testString() {
        String result = jedis.set("name", "张三2");
        System.out.println("result = " + result);

        String name = jedis.get("name");
        System.out.println("name = " + name);
    }

    @Test
    void testMap() {
        jedis.hset("user:1", "name", "jack");
        jedis.hset("user:1", "age", "21");

        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println("map = " + map);
    }


    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }

}