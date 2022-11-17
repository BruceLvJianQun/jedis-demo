package com.jianqun.test2;

import com.jianqun.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * Redis连接池进行连接
 */
public class chiJedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp() {
        jedis = JedisConnectionFactory.getJedis();
    }

    @Test
    void test(){
        //存入数据
        String result = jedis.set("name", "虎哥");
        System.out.println("存储成功与否:" + result);

        //获取数据
        String name = jedis.get("name");
        System.out.println("获取的name值是:" + name);
    }

    @AfterEach
    void tearDown() {
        if (jedis != null){
            jedis.close();
        }
    }

}
