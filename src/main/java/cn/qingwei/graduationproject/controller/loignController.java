package cn.qingwei.graduationproject.controller;

import cn.qingwei.graduationproject.pojo.User;
import cn.qingwei.graduationproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller

public class loignController {
    @Autowired
    private  UserService userService=null;
    @RequestMapping("/index")
    public String index(){
        System.out.println("test");
        return "index";
    }
//@RequestMapping("/404")
//public String geterror(HttpServletRequest request){
//
//    return "error";
//
//}


@RequestMapping("/login")
    public String login(HttpServletRequest request){
    System.out.println("test");
    if(request.getSession().getAttribute("user_name")!=null)
        return "index";
    return "login";

    }


@PostMapping("/tologin")
@ResponseBody

    public Map<String,Object>  toloign(@RequestBody User user, HttpServletRequest request, HttpServletResponse response)throws IOException{
        Map<String,Object> result=new HashMap<>();
    System.out.println("________");
    System.out.println(userService.getUserbyusernameandpassword(user.getUsername(),user.getPassword()));
        if(userService.getUserbyusernameandpassword(user.getUsername(),user.getPassword())==null){
            result.put("message", "用户名或者密码不正确");
            result.put("status",false);

            return result;
        }
        else if(userService.getUserisactive(user.getUsername())==null){
            result.put("message", "账号未激活");
            result.put("status",false);
            return result;
        }else {
            request.getSession().setAttribute("user_name",userService.getUserisactive(user.getUsername()).getUsername());
            request.getSession().setAttribute("user_id",userService.getUserisactive(user.getUsername()).getId());
            result.put("message", "登陆成功 2秒后跳转到主页面");
            result.put("status",true);
            return result;
        }




    }
@RequestMapping("/logout")
public void longout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("user_name",null);
        request.getSession().setAttribute("user_id",null);

    response.sendRedirect("/login");
}




}
