package com.tsu.zqy.redisAndMybatis.test;

import com.google.common.collect.Maps;
import com.tsu.zqy.redisAndMybatis.util.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Set;

/**
 * @ClassName JedisTest
 * @Author Elv1s
 * @Date 2019/5/20 14:12
 * @Description:
 *                 Jedis测试
 */
public class JedisTest {

    @Test
    public void test1(){

        Jedis jedis = JedisUtil.getJedis();

        System.out.println("--------keys--------------");
        //所有的key
        Set<String> allKeys = jedis.keys("*");
        System.err.println(allKeys);

        System.out.println("--------String--------------");
        //String类型 设置 KV  通过key 获得 value
        jedis.set("jedis", "hello world");
        System.out.println(jedis.get("jedis"));

        System.out.println("--------list--------------");
        //清空list    end < start
        jedis.ltrim("jedisList", 1, 0);
        //可以添加多个元素
        jedis.lpush("jedisList", "one","two","three");
        //也可以只添加一个元素
        jedis.lpush("jedisList", "4");
        //list中第0个到第六个     (角标从0开始)
        System.out.println(jedis.lrange("jedisList", 0, 6));

        System.out.println("--------hashmap--------------");
        jedis.del("hash");
        jedis.hset("hash", "student1", "tom");
        jedis.hset("hash", "student2", "jack");
        HashMap<String, String> map = Maps.newHashMap();
        map.put("1", "第一");
        map.put("2", "第二");
        map.put("3", "第三");
        map.put("4", "第四");
        map.put("5", "第五");

        jedis.hmset("hash",map);
        System.out.println(jedis.hget("hash", "2"));
        System.out.println(jedis.hgetAll("hash"));

    }

    @Test
    public void test2(){
        Jedis jedis = JedisUtil.getJedis();

        System.out.println("--------------- set --------------");
        //可以存一个或者多个
        jedis.sadd("jedis4set", "hello world","ni hao shijie");
        System.out.println(jedis.smembers("jedis4set"));

        System.out.println("-------------- zset ------------");
        //有序    按照 score 的值 升序排列
        jedis.zadd("zset", 1, "第一");

        HashMap<String, Double> map = Maps.newHashMap();
        map.put("第二", 2d);
        map.put("第三", 3d);
        map.put("第四", 4d);
        //可以加map
        jedis.zadd("zset" , map);

        System.out.println(jedis.zrange("zset", 0, 10));

        //前两名
        System.out.println(jedis.zrangeByScore("zset", 0, 2));

    }

}