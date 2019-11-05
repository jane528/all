package cn.seek.jdbctemplate;


import cn.seek.domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JTemplate1 {

    JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
    @Test
    public void test1(){
        //1.修改1号数据salary为10000

        String sql ="update emp set salary=10000 where id=?";
        int count = template.update(sql,1);
        if(count>0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
    }

    @Test
    public void test2(){
        //2.添加一条记录
        String sql = "insert into emp(name,gender,salary) values(?,?,?)";
        int count = template.update(sql,"王测试","男",2000);
        if(count>0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
    }

    @Test
    public void test3(){
        //3.删除一条记录
        String sql = "delete from emp where id=?";
        int count = template.update(sql,2);
        if(count>0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
    }

    @Test
    public void test4(){
        //4.查询id为1的记录，将其封装为Map集合
        String sql = "select * from emp where id=?";
        Map<String,Object> m = template.queryForMap(sql,1);
        System.out.println(m);
    }

    @Test
    public void test5(){
        //5.查询所有记录，将其封装为List集合
        String sql = "select * from emp";
        List<Map<String, Object>>  list = template.queryForList(sql);
        for(Map<String, Object> map:list){
            System.out.println(map);
        }
    }

    @Test
    public void test6(){
        //6.查询所有记录，将其封装为emp对象的List集合
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {

            @Nullable
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {

                Emp emp = new Emp();
                int id =rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                double salary = rs.getDouble("SALARY");
                Date join_date =  rs.getDate("JOIN_DATE");
                int dept_id = rs.getInt("DEPT_ID");

                emp.setId(id);
                emp.setName(name);
                emp.setGender(gender);
                emp.setSalary(salary);
                emp.setJoin_date(join_date);
                emp.setDept_id(dept_id);

                return emp;
            }
        });
        for(Emp emp:list){
            System.out.println(emp);
        }
    }


    @Test
    public void test7() {
        //6.查询所有记录，将其封装为emp对象的List集合
        String sql = "select * from emp";
        List<Emp> list = template.query(sql,new BeanPropertyRowMapper<Emp>(Emp.class));
        for(Emp emp:list){
            System.out.println(emp);
        }
    }

    @Test
    public void test8() {
        //7.查询总记录数
        String sql = "select count(1) from emp";
        long total = template.queryForObject(sql,Long.class);
        System.out.println(total);
    }


}
