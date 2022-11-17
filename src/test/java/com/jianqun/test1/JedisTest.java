package com.jianqun.test1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTest {
   private Jedis jedis;

   @BeforeEach
   void setUp() {
      //1.建立连接
     jedis = new Jedis("192.168.148.3", 6379);
      //2.设置密码
      jedis.auth("190915");
      //选择库
      jedis.select(0);
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

   //测试Hash数据结构
   @Test
   void testHash() {
      // 插入数据，方法名称就是redis命令名称，非常简单
      jedis.hset("user:1", "name","张三");
      jedis.hset("user:1", "age","12");
      //获取数据
      Map<String, String> Map = jedis.hgetAll("user:1");
   }

   @AfterEach
   void tearDown() {
      if (jedis != null){
         jedis.close();
      }
   }
}
