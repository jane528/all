package cn.seek;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class controller {

    @RequestMapping("test")
    public String  test(){
        System.out.println("test");

        return "login/login";
    }

}
