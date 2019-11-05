package cn.seek;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/FindHServlet")
public class FindHServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String method=request.getMethod();
        StringBuffer url=request.getRequestURL();
        String uri=request.getRequestURI();
        String scheme=request.getScheme();
        System.out.println("请求行："+method+" "+uri+" "+scheme);
        System.out.println("********************************************");

        Enumeration enumeration=request.getHeaderNames();
        System.out.println("请求头：");
        while(enumeration.hasMoreElements()) {
            String name=(String)enumeration.nextElement();
            String value=request.getHeader(name);
            System.out.println(name+":"+value);
        }
        System.out.println("********************************************");
        System.out.println(new Test().getParm(request));

        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code",1);
        res.put("message","成功");
        ObjectMapper om = new ObjectMapper();
        om.writeValue( response.getWriter(),res);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
