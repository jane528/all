package cn.seek.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC02 {
    public static void main(String[] args) {
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        Connection conn = null;
        JdbcUtil ju = new JdbcUtil();

        //1.用户1减500、用户2加500
        String sql1 = "update account set balance=balance-? where id = ?";
        String sql2 = "update account set balance=balance+? where id = ?";
        try {
            conn = ju.getconnection();
            //开启事务
            conn.setAutoCommit(false);

            ps1 = conn.prepareStatement(sql1);
            ps2 = conn.prepareStatement(sql2);
            //设置参数
            ps1.setDouble(1,500);
            ps1.setInt(2,1);
            ps2.setDouble(1,500);
            ps2.setInt(2,4);

            int res1 = ps1.executeUpdate();
            System.out.println(res1);
            int i = 1/0;
            int res2 =ps2.executeUpdate();
            System.out.println(res2);
            conn.commit();

        } catch (Exception e) {
            //事务回滚
            try {
                if(conn != null){
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            ju.close(ps1,conn);
            ju.close(ps2,null);
        }

    }
}
