package com.wcc.mytest.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

/**
* @ClassName: RedisUtil
* @Description: 操作redis缓存的工具类，简单的demo，方便入门初步理解redis
* @Author: wangchenchen
* @Date: 2020/10/20 18:27
* @Version: v1.0 文件初始创建
*/
public class RedisUtil {

    public static void RedisUtil(){

        //https://blog.csdn.net/fu_zhongyuan/article/details/88235172
        JedisShardInfo jedisShardInfo = new JedisShardInfo("redis://127.0.0.1:6379/9");//这里是连接的本地地址和端口
        jedisShardInfo.setPassword("123456");

        //1、创建jedis对象，需要指定连接的地址和端口
        Jedis jedis = new Jedis(jedisShardInfo);
        // jedis.connect();
        //jedis.setPassword("123456");
        //2、直接操作jedis set
        jedis.set("username1","wangchenchen");
        System.out.println(jedis.get("username"));
        System.out.println("server is running:" + jedis.ping());
        jedis.set("test","localhost connection sucessfully");
        //3、关闭连接
        jedis.close();
        /*JedisShardInfo jedisShardInfo = new JedisShardInfo("redis://127.0.0.1:6379/2");
        jedisShardInfo.setPassword("123456");
        Jedis jedis = new Jedis(jedisShardInfo);
        long start = System.currentTimeMillis();
        System.out.println(start);
        for(int i = 0;i < 10;i++){
            String result = jedis.set("n" + i,"n" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("simple SET need :" +((end - start)/1000.0) + " seconds");
        jedis.disconnect();*/
    }

    public static void main(String[] args){
        RedisUtil();
    }

   /* //以下配置可用可不用
    private static Jedis jedisxuan;//redis实例
    private static String host;//地址
    private static String port;// 端口
    private static String password;// 授权密码
    private static String timeout;// 超时时间：单位ms
    private static String maxIdle;// 最大空闲数：空闲链接数大于maxIdle时,将进行回收
    private static String maxActive;// 最大连接数：能够同时建立的"最大链接个数"
    private static String maxWait;// 最大等待时间：单位ms
    private static String testOnBorrow;// 在获取连接时，是否验证有效性

    //静态代码块
    static{
        //加载properties配置文件
        Properties properties = new Properties();
        InputStream inputStream = RedisUtil.class.getClassLoader().getResourceAsStream("redis.properties");
        try{
            properties.load(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        host = properties.getProperty("redis.host");
        port = properties.getProperty("redis.port");
        password = properties.getProperty("redis.password");
        timeout = properties.getProperty("redis.timeout");
        maxIdle = properties.getProperty("redis.maxIdle");
        maxActive = properties.getProperty("redis.maxActive");
        maxWait = properties.getProperty("redis.maxWait");
        testOnBorrow = properties.getProperty("redis.testOnBorrow");
        // 得到Jedis实例并且设置配置
        jedisxuan = new Jedis(host, Integer.parseInt(port),
                Integer.parseInt(timeout));
    }*/

}
