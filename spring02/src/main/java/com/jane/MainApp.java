package com.jane;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class MainApp {

    public static void main(String[] args) {
        //容器加载的两种方式：
        //第一种：使用ClassPathXMLApplicationContext，执行后在classes文件下
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //第二种：使用FileSystemXmlApplicationContext,参数为配置文件所在绝对路径
//        ApplicationContext context = new FileSystemXmlApplicationContext("E:/java/spring02/src/main/resources/applicationContext.xml");



        HelloWorld hw = (HelloWorld) context.getBean("helloWorld");
        System.out.println("this message is:"+hw.getMessage());
    }
}
