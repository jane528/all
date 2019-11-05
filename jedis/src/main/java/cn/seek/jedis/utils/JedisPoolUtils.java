package cn.seek.jedis.utils;

import com.sun.org.apache.xpath.internal.SourceTree;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/******************************
*jedis工具类
* 加载配置文件，配置连接池的参数
*提供获取连接的方法
* ****************************/
public class JedisPoolUtils {
    private static JedisPool jedispool;

    static {
        //读取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        System.out.println(is);
        Properties pro = new Properties();
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));
        String host = pro.getProperty("host");
        System.out.println(host);
        int port=Integer.parseInt(pro.getProperty("port"));
        System.out.println(port);
        jedispool = new JedisPool(config,host,port);

    }

    //获取连接方法
    public static Jedis getJedis(){
        return jedispool.getResource();
    }
}
