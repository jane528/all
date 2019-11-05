package cn.seek.pool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Pool {

    public static void main(String[] args) {
        //1.创建ComboPooledDataSource对象
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        //2.获取连接对象
        try {
            for(int i=0;i<10;i++){
                Connection conn = ds.getConnection();
                System.out.println(conn);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
