package cn.seek.druid;

import utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Druid {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("输入用户名：");
        String name = sc.nextLine();
        System.out.println("输入密码：");
        String password = sc.nextLine();


        //1.定义sql
        String sql = "select * from users where name=? and password=?";
        JdbcUtils ju = new JdbcUtils();
        conn = ju.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ju.close(rs,ps,conn);
        }
    }
}
