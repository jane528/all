package cn.seek;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/AjaxServlet")
public class AjaxServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       response.setContentType("application/json;charset=utf-8");
        //1.获取请求参数
        String username = request.getParameter("username");
        //打印
        System.out.println(username);
        //返回查询结果，使用json串的形式
        Map<String,Object> map = new HashMap<String,Object>();
        if("tom".equals(username)){
            map.put("UserExist",true);
            map.put("msg","用户名太受欢迎，请换一个");
        }else{
            map.put("UserExist",false);
            map.put("msg","用户名可用");
        }
        ObjectMapper om = new ObjectMapper();
        om.writeValue( response.getWriter(),map);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
