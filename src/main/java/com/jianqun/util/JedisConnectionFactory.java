package com.jianqun.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis连接池
 */
public class JedisConnectionFactory {
    private static final JedisPool jedisPool;
    static {
        // 配置连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接
        jedisPoolConfig.setMaxTotal(8);
        // 最大空闲连接
        jedisPoolConfig.setMaxIdle(8);
        // 最小空闲连接
        jedisPoolConfig.setMinIdle(0);
        // 设置最长等待时间， ms
        jedisPoolConfig.setMaxWaitMillis(200);
        // 创建连接池对象
        jedisPool = new JedisPool(jedisPoolConfig, "192.168.148.3", 6379,1000, "190915");
    }

    // 获取Jedis对象
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
