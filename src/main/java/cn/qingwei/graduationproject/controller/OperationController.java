package cn.qingwei.graduationproject.controller;

import cn.qingwei.graduationproject.pojo.Crowdfunding;
import cn.qingwei.graduationproject.service.CrowfundingService;
import cn.qingwei.graduationproject.service.OrderService;
import cn.qingwei.graduationproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OperationController {
    @Autowired
    UserService userService;
    @Autowired
    JavaMailSenderImpl mailSender;
    @Autowired
    CrowfundingService crowfundingService;
    @Autowired
    OrderService orderService;
@ResponseBody
@RequestMapping("/tosentmsg")
  public Map<String,Object> tosentmsg(int cid,String msg){
    System.out.println(Thread.currentThread().getName());
      Map<String,Object> result=new HashMap<>();
    List<String> emails=userService.getallnotifyemail(cid);
    String title =crowfundingService.gettitlebyid(cid);
    sentemail(emails,msg,title);
    result.put("status",1);

      return result;


  }


  @RequestMapping("/sentitem")
  @ResponseBody
  public Map<String,Object> sentitem(int cid){
      System.out.println(cid);
      Map<String,Object> result=new HashMap<>();
//      List<String> emails=userService.getallnotifyemail(cid);
//      String title =crowfundingService.gettitlebyid(cid);
//      sentemail(emails,msg,title);
//      result.put("status",1);


         orderService.sentitem(cid);
         crowfundingService.sentitem(cid,4);
      System.out.println("————————");
      result.put("status",1);
      result.put("msg","发货成功");
      return result;


  }







    @Async
    public void sentemail(List<String> emails,  String msg,String title){
        System.out.println(Thread.currentThread().getName());
        for (String email:emails){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("你在Pex众筹参与的项目--"+title+"有了一则更新");

        message.setText(msg);
        message.setTo(email);
        message.setFrom("17803865542@163.com");

        mailSender.send(message);
        }

    }
}
