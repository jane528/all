package cn.seek.jdbc;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import java.net.URL;

public class JdbcUtil {

    private static String driver;
    private static String url;
    private static String name;
    private static String password;

    private static Connection conn = null;
    private static Statement st = null;
    private static ResultSet rs = null;



    //文件的读取，只需要读取一次,使用静态代码块
    static{
        try {
            //获取src路径下的文件方式-->ClassLoader类加载器
            ClassLoader classloader = JdbcUtil.class.getClassLoader();
            URL resource = classloader.getResource("jdbc.properties");
            String path = resource.getPath();

            //读取资源文件
            Properties p = new Properties();
            /**
             * 读取资源文件的第一种方式
             InputStream is = new BufferedInputStream(new FileInputStream(path));
            p.load(is);
             */
            //读取资源文件的第二种方式
            p.load(new FileReader(path));
            driver = p.getProperty("driver");
            name = p.getProperty("name");
            password = p.getProperty("password");
            url = p.getProperty("url");
            Class.forName(driver);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    //1.创建连接
    public static Connection getconnection(){
        try {

            conn = DriverManager.getConnection(url,name,password);
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //2.将执行sql作为入参，返回resultset结果 --查询
    public  ResultSet exQuery(String sql){
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    //2.将执行sql作为入参，返回影响行数---增删改
    public int executeUpdate(String sql){
        int res = 0;
        try {
            st = conn.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    //3.关闭资源
    public  void close(ResultSet rs,Statement st,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //4.关闭资源重载
    public  void close(Statement st,Connection conn){
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        JdbcUtil.conn = conn;
    }

    public static Statement getSt() {
        return st;
    }

    public static void setSt(Statement st) {
        JdbcUtil.st = st;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static void setRs(ResultSet rs) {
        JdbcUtil.rs = rs;
    }
}
