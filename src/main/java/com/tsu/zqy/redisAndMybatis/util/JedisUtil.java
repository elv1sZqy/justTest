package com.tsu.zqy.redisAndMybatis.util;

import redis.clients.jedis.Jedis;

/**
 * @ClassName JedisUtil
 * @Author Elv1s
 * @Date 2019/5/20 14:30
 * @Description:
 *              操作redis
 */
public class JedisUtil {

    public static Jedis getJedis(){

        //地址加端口
        Jedis jedis = new Jedis("youraddress”, 6379);

        //密码
        jedis.auth("your password");

        //连接
        jedis.connect();

        return jedis;
    }

}
