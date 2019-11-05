package cn.seek.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMysql {

    public static void main(String[] args){
        List<Emp> list = new ArrayList<Emp>();
        list = FindAll();
        System.out.println(list);
        for(Emp emp:list){
            System.out.println(emp.getId()+"--"+emp.getName()+"--"+emp.getGender()+"--"+emp.getSalary()+"--"+emp.getJOIN_DATE()+"--"+emp.getDept_id());
        }
    }

    public static  List<Emp> FindAll(){
         List<Emp> list = new ArrayList<Emp>();
         ResultSet rs = null;
         JdbcUtil ju = new JdbcUtil();
         String sql = "select * from emp";
         ju.getconnection();
         rs = ju.exQuery(sql);
        try {
            while(rs.next()){
                    Emp emp = new Emp();
                    emp.setId(rs.getInt("id"));
                    emp.setName(rs.getString("name"));
                    emp.setGender(rs.getString("gender"));
                    emp.setSalary(rs.getFloat("salary"));
                    emp.setJOIN_DATE(rs.getDate("join_date"));
                    emp.setDept_id(rs.getInt("dept_id"));
                    list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ju.close(rs,ju.getSt(),ju.getConn());
     return list;
    }
}
