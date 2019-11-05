package cn.seek.jedis.test;

import cn.seek.jedis.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestJedis {

    @Test
    public void test1(){
        //1.获取链接
        Jedis jedis = new  Jedis("127.0.0.1",6379);
        //2.操作String
        jedis.set("username","zhangsan");
        String username = jedis.get("username");
        jedis.del("username");
        jedis.setex("test",30,"123456");

        //2.操作hash
        jedis.hset("set","field","value");
        //hset的使用方法
        Map<String,String> map1 = new HashMap<String, String>();
        map1.put("key1","value1");
        jedis.hset("set",map1);
        jedis.hget("set","key1");
        jedis.hgetAll("set");

        //hmset的使用方法
        Map<String,String> map2 = new HashMap<String, String>();
        map2.put("name","zhangsan");
        map2.put("password","1234");
        map2.put("sex","male");
        jedis.hmset("set",map2);
        jedis.hmget("set","name","password");

        Map<String,String> map3 = jedis.hgetAll("set");
        System.out.println(map3);

        //3.关闭连接
        jedis.close();
    }

    @Test
    public void Test2(){
        //1.获取连接
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //2.操作list
        //1.添加lpush、rpush
        jedis.lpush("canshu1","value1","value5");
        jedis.rpush("canshu1","value2","value3","value4");
        //2.获取canshu1的所有值
        System.out.println(jedis.lrange("canshu1",0,-1));
        //3.删除某一个值
        System.out.println(jedis.lpop("canshu1"));
        //获取长度
        System.out.println(jedis.llen("canshu1"));
        //3.关闭链接
        jedis.close();
    }

    @Test
    public void Test3(){
        //1.获取连接
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //2.操作
        //1.添加
        jedis.sadd("sql","mysql","sql server","oracle");
        //2.获取
        Set<String> sql = jedis.smembers("sql");
        System.out.println(sql);
        jedis.close();
    }

    @Test
    public void Test4(){
        //1.获取连接
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //添加
        jedis.zadd("sortedset",1,"top1");
        jedis.zadd("sortedset",2,"top2");
        //获取成员数
        System.out.println(jedis.zcard("sortedset"));
        //获取所有value
        Set<String> sortset = jedis.zrange("sortedset",0,-1);
        System.out.println(sortset);
        jedis.close();
    }

    @Test
    public void Test5(){
        JedisPool jedispool = new JedisPool("192.168.29.94",6379);
        //获取
        Jedis jedis = jedispool.getResource();
        jedis.set("app:user:test","6666");
        //归还连接
        jedis.close();
    }

    @Test
    public void Test6(){
            Jedis jedis = JedisPoolUtils.getJedis();
            jedis.set("app:user:test0123","1234");
            jedis.close();
    }
}
