package cn.seek.test;

import cn.seek.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class jackson {

    //java对象转化为json
   @Test
    public void test1() throws JsonProcessingException {

       //1.创建Person对象
       Person p = new Person();
       p.setUsername("杰克");
       p.setAge(23);
       p.setGender("男");
       //2.创建jackson核心对象  ObjectMapper
       ObjectMapper mapper = new ObjectMapper();
       //3.调用ObjectMapper的相关方法进行转换
       String jsonstr = mapper.writeValueAsString(p);
       System.out.println(jsonstr);
   }

   //java对象数组转化为json
    @Test
    public void test2() throws Exception {
       List<Person> al = new ArrayList<Person>();

       Person p = new Person();
       p.setUsername("杰克");
       p.setAge(23);
       p.setGender("男");
       al.add(p);

        Person p1 = new Person();
        p1.setUsername("杰克");
        p1.setAge(23);
        p1.setGender("男");
        al.add(p1);

        //创建ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        String jsonstr = mapper.writeValueAsString(al);
        System.out.println(jsonstr);
        //将转换结果存到文件中
        mapper.writeValue(new File("d://a.txt"),al);
        mapper.writeValue(new FileWriter("d://b.txt"),al);

    }

    //java对象数组转化为json
    @Test
    public void test3() throws Exception {
        Map<String,Object> p = new HashMap<String,Object>();
        p.put("username","肉丝");
        p.put("age",30);
        p.put("gender","男");

        //创建ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        String jsonstr = mapper.writeValueAsString(p);
        System.out.println(jsonstr);
    }
    //json对象转化为java对象
    @Test
    public void test4() throws Exception{
       //定义json字符串
       String json = "{\"gender\":\"男\",\"age\":30,\"username\":\"肉丝\"}";
       //创建核心对象
        ObjectMapper om = new ObjectMapper();
        //转换json为person对象
        Person p = om.readValue(json,Person.class);
        System.out.println(p);

    }

}
