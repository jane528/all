package cn.seek.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("用户名：");
        String username = sc.nextLine();
        System.out.println("密码：");
        String ps = sc.nextLine();
        boolean res = false;
        try {
            res = login(username,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(res){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }


    public static boolean login(String username,String ps) throws SQLException {
        Connection conn;
        ResultSet rs;
        if(username == null || ps ==null){
            return false;
        } else{
            JdbcUtil ju = new JdbcUtil();
            conn = ju.getconnection();
            String sql = "select * from user where username=? and ps = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,ps);
            rs = preparedStatement.executeQuery();
            try {
                return rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                ju.close(rs,preparedStatement,conn);
            }
        }
        return false;
    }

}
