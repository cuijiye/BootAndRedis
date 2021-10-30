package com.example.bootredis;

import com.example.bootredis.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class BootRedisApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

//        RedisTemplate  操作不同的数据类型，api和官方文档指令一致
//        除了基本的操作，我们常用的方法都可以直接通过RedisTemplate操作，比如事务和基本的CRUD
//        获取Redis的连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();

        redisTemplate.opsForValue().set("test","测试");
        System.out.println(redisTemplate.opsForValue().get("test"));
    }

    @Test
    public void testSeril(){
        User user = new User("张三", 6);
        try {
            String s = new ObjectMapper().writeValueAsString(user);
            redisTemplate.opsForValue().set("user", s);
            System.out.println(redisTemplate.opsForValue().get("user"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
