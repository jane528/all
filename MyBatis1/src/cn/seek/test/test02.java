package cn.seek.test;

import cn.seek.dao.EmpMapper;
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

public class test02 {
    SqlSession ss;
    @Before
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        ss = ssf.openSession();
    }

    @After
    public void after(){
        ss.close();
    }
    @Test
    public void test1(){
        EmpMapper empMapper = ss.getMapper(EmpMapper.class);

        Emp emp = new Emp();
        emp.setName("dao测试1");
        emp.setSalary(20000);
        emp.setGender("女");

        int affectRow = empMapper.insertbackid1(emp);
        ss.commit();
        System.out.println("--------------------------");
        System.out.println(affectRow);
        System.out.println(emp.getId());
        System.out.println("--------------------------");
    }
}
