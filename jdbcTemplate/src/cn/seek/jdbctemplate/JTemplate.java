package cn.seek.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;

public class JTemplate {
    public static void main(String[] args) {
        //1.导入jar包
        //创建jdbctemplate
        JdbcUtils ju = new JdbcUtils();
        JdbcTemplate template = new JdbcTemplate(ju.getDataSource());
        String sql = "update account set balance = 100 where id=?";
        int count = template.update(sql,1);
        System.out.println(count);
    }
}
