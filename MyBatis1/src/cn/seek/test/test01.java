package cn.seek.test;


import cn.seek.domain.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class test01 {

    SqlSession ss;
    @Before
    public void before()throws IOException{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        ss = ssf.openSession();
    }

    @After
    public void after(){
        ss.close();
    }

    @Test
    public void test1()  {

        Emp emp = ss.selectOne("findById",1);
        System.out.println(emp);

    }

    @Test
    public void test2(){
        List<Emp> list = ss.selectList("FuzzyfindByName","王");
        for(Emp emp:list){
            System.out.println(emp);
        }
    }

    @Test
    public void test3(){
        Emp emp = new Emp();
        emp.setId(10);
        emp.setName("重复11");
        emp.setGender("女");
        emp.setSalary(2300);
        emp.setJoin_date("2019-02-03");
        emp.setDept_id(5);
        System.out.println(emp);
        int affectRow = ss.insert("insertEmp",emp);
        System.out.println("----------------");
        System.out.println("----------------");
        System.out.println(affectRow);
        ss.commit();
    }

    @Test
    public void test4(){
        int affectRow = ss.delete("deleteEmp",10);
        System.out.println("影响行数：");
        System.out.println(affectRow);
        ss.commit();
    }

    @Test
    public void test5(){
        Emp emp = new Emp();
        emp.setId(25);
        emp.setName("更新");
        emp.setSalary(10000);
        int affectRow = ss.update("updateEmp",emp);
        System.out.println("影响行数：");
        System.out.println(affectRow);
        ss.commit();

    }

    @Test
    public void test6(){
        Emp emp = new Emp();
        emp.setName("返回值3");
        emp.setGender("女");
        emp.setSalary(2300);
        emp.setJoin_date("2019-02-03");
        emp.setDept_id(5);
        System.out.println(emp);
        int affectRow = ss.insert("insertbackid1",emp);
        System.out.println("----------------");
        System.out.println("----------------");
        System.out.println(affectRow);
        System.out.println(emp.getId());
        ss.commit();
    }


    @Test
    public void test7(){
        Emp emp = new Emp();
        emp.setName("返回值4");
        emp.setGender("女");
        emp.setSalary(2300);
        emp.setJoin_date("2019-02-03");
        emp.setDept_id(5);
        System.out.println(emp);
        int affectRow = ss.insert("insertbackid2",emp);
        System.out.println("----------------");
        System.out.println("----------------");
        System.out.println(affectRow);
        System.out.println(emp.getId());
        ss.commit();
    }

}
