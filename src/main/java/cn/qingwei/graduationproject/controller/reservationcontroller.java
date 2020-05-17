package cn.qingwei.graduationproject.controller;

import cn.qingwei.graduationproject.mapper.ReservationMapper;
import cn.qingwei.graduationproject.pojo.*;
import cn.qingwei.graduationproject.service.CommentService;
import cn.qingwei.graduationproject.service.CrowfundingService;
import cn.qingwei.graduationproject.service.ReservationService;
import cn.qingwei.graduationproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class reservationcontroller {
    @Autowired
    CommentService commentService;
    @Autowired
    CrowfundingService crowfundingService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    UserService userService;
    @RequestMapping("getreservation")
    @ResponseBody
    public Map<String,Object> getreservationindex(HttpServletRequest request, HttpServletResponse response){
        int sum=12;
        String way= (String) request.getSession().getAttribute("way");
        int  cur= (int) request.getSession().getAttribute("cur");
        int uid=(int) request.getSession().getAttribute("user_id");
        List<Crowdfundingplus> crowdfundings;
        Map<String,Object> result=new HashMap<>();
        if (way.equals("top_time")){
             crowdfundings=crowfundingService.gettop_timepreheat((cur-1)*sum,sum,uid);
        }else{
            crowdfundings=crowfundingService.gethotpreheat((cur-1)*sum,sum,uid);
            System.out.println(crowdfundings);
        }
           int count=crowfundingService.getpreheatcount();
        int cur_page=cur;
        int page_count=count/sum;
           result.put("count",count);
           result.put("crowdfundings",crowdfundings);
           result.put("cur_page",cur_page);
           result.put("page_count",page_count);
           result.put("way",way);


        return result;
    }
    @RequestMapping("/all/preheat/{way}/{cur}")
    public String reservation(@PathVariable("way") String way, @PathVariable("cur") int cur,HttpServletRequest request, HttpServletResponse response){
        if (way.equals("top_time")||way.equals("hot")){


        request.getSession().setAttribute("way",way);
        request.getSession().setAttribute("cur",cur);
        return "reservation/indexpage";
        }else {
            return "404";
        }
    }

    @RequestMapping("/all/preheat/{way}")
    public String reservationindex(@PathVariable("way") String way,HttpServletRequest request, HttpServletResponse response){
        if (way.equals("top_time")||way.equals("hot")){


            request.getSession().setAttribute("way",way);
            request.getSession().setAttribute("cur",1);
            return "reservation/indexpage";
        }else {
            return "404";
        }
    }






    @RequestMapping("/reservationcrowdfunding")
    @ResponseBody
    public Map<String,Object> reservationcrowdfunding(int cid,HttpServletRequest request, HttpServletResponse response){
        int uid=(int) request.getSession().getAttribute("user_id");
        Map<String,Object> result=new HashMap<>();
        Integer rs=reservationService.insertreservation(cid,uid);
        Integer r=crowfundingService.updatereservationsum(cid);
        if (rs!=0&&r!=0){
            result.put("status",1);
            result.put("msg","你已经成功预约");

        }else {
            result.put("status",0);
            result.put("msg","系统繁忙,请稍后再试");
        }




        return result;

    }

    @RequestMapping("/delreservation")
    @ResponseBody
    public Map<String,Object> delreservation(int cid,HttpServletRequest request, HttpServletResponse response){
        int uid=(int) request.getSession().getAttribute("user_id");
        Map<String,Object> result=new HashMap<>();
        Integer rs=reservationService.delreservation(cid,uid);
        Integer r=crowfundingService.queeservationsum(cid);
        if (rs!=0&&r!=0){
            result.put("status",1);
            result.put("msg","你已经成功取消预约");

        }else {
            result.put("status",0);
            result.put("msg","系统繁忙,请稍后再试");
        }




        return result;

    }

    @RequestMapping("/reservation/{id}")
    public String reservation(@PathVariable("id") int id,HttpServletRequest request, HttpServletResponse response){
        if (crowfundingService.isexitreservation(id)!=0){
            request.getSession().setAttribute("reservationid",id);
            return "reservation";
        }else {
            return "404";
        }
    }



    @RequestMapping("/getreservationbyid")
    @ResponseBody
    public Map<String,Object> getreservationbyid(HttpServletRequest request, HttpServletResponse response){

        int cid= (int) request.getSession().getAttribute("reservationid") ;
        int uid=(int) request.getSession().getAttribute("user_id") ;

        Crowdfundingplus crowdfunding=crowfundingService.getreservationbyid(cid,uid);
        crowdfunding.setId(cid);
        System.out.println(crowdfunding);
        User user=userService.getuserbyid(crowdfunding.getUid());
        String creater_acvtor=user.getAcvtor();
        String  creater_habitation=user.getHabitation();
        Map<String,Object> result=new HashMap<>();
        List<Comment> comments=commentService.getcomment(cid);
        result.put("crowdfunding",crowdfunding);
        result.put("creater_acvtor",creater_acvtor);
        result.put("creater_habitation",creater_habitation);
        result.put("comments",comments);

        return result;


    }

}
