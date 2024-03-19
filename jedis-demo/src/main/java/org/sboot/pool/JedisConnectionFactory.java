package org.sboot.pool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class JedisConnectionFactory {

    private static final JedisPool JEDIS_POOL;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 最大连接数
        config.setMaxTotal(8);
        // 最大空闲
        config.setMaxIdle(8);
        // 最小空闲
        config.setMinIdle(0);
        // 最长等待时间
        config.setMaxWait(Duration.ofMillis(200));
        JEDIS_POOL = new JedisPool(config, "192.168.39.10", 6379);
    }

    // 获取jedis对象
    public static Jedis getJedis() {
        return JEDIS_POOL.getResource();
    }

}
