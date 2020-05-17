package cn.qingwei.graduationproject.controller;

import cn.qingwei.graduationproject.pojo.Admin;
import cn.qingwei.graduationproject.pojo.Crowdfundingplus;
import cn.qingwei.graduationproject.pojo.PageConf;
import cn.qingwei.graduationproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class lauipage {
    @Autowired
    CrowfundingService crowfundingService;
    @Autowired
    GearService gearService;
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    @Autowired
    OrderService orderService;


    @RequestMapping("/testq")
    @ResponseBody
    public Map<String,Object> testq(PageConf pageConf){
        System.out.println(pageConf);
        System.out.println("_____");
        Map<String,Object> result=new HashMap<>();
        int count=adminService.getadmincount();
        List<Admin> admins=adminService.getalladmins(pageConf.getCurrentPage(), pageConf.getPageSize());
        System.out.println();
        result.put("total",count);
        result.put("admins",admins);
        return  result;

    }


    @RequestMapping("/indexpage")

    public String indexpage(){
        return  "indexpage/indexpage";

    }

    @RequestMapping("indexpage/enddate")

    public String indexpagebyenddate(){
        return  "indexpage/enddate";

    }
    @RequestMapping("indexpage/money")

    public String indexpagebymoney(){
        return  "indexpage/money";

    }
    @RequestMapping("indexpage/count")

    public String indexpagebycount(){
        return  "indexpage/count";

    }


    @RequestMapping("/getindexcrowfunding")
    @ResponseBody
    public Map<String,Object> getindexcrowfunding(PageConf pageConf){
        System.out.println(pageConf);
        System.out.println("_____");
        Map<String,Object> result=new HashMap<>();
        List<Crowdfundingplus> admins;
        int count=crowfundingService.getCrowfundingcountbystatus(1);
        if (pageConf.getRule().equals("begin_date")){
            admins=crowfundingService.getCrowfundingpluscountbystatus(1,(pageConf.getCurrentPage()-1)*pageConf.getPageSize(),pageConf.getPageSize());
        }else if (pageConf.getRule().equals("end_date")){
            admins=crowfundingService.getCrowfundingpluscountbyendtime(1,(pageConf.getCurrentPage()-1)*pageConf.getPageSize(),pageConf.getPageSize());
        }else if (pageConf.getRule().equals("currentamout")){
            admins=crowfundingService.getCrowfundingpluscountbycurrentamout(1,(pageConf.getCurrentPage()-1)*pageConf.getPageSize(),pageConf.getPageSize());
        }else {
            admins=crowfundingService.getCrowfundingpluscountbycount(1,(pageConf.getCurrentPage()-1)*pageConf.getPageSize(),pageConf.getPageSize());
        }

        for (Crowdfundingplus crowdfunding:admins){
            System.out.println(crowdfunding.getId());
        }
        System.out.println();
        result.put("total",count);
        result.put("admins",admins);
        return  result;

    }
    @RequestMapping("/search")
    public String getsearch(String search, HttpServletRequest request, HttpServletResponse response){
        if(search==null){
            return "index";
        }else {


       Integer count=crowfundingService.getsearchcount(search);
            request.setAttribute("search",search);
            request.getSession().setAttribute("search",search);
            request.setAttribute("count",count);

        return  "search";
        }
    }


    @RequestMapping("/getsearchcrowfunding")
    @ResponseBody
    public Map<String,Object> getsearchcrowfunding(PageConf pageConf,HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result=new HashMap<>();
        System.out.println(pageConf);
        String search=(String)request.getSession().getAttribute("search");
        Integer count=crowfundingService.getsearchcount(search);
         List<Crowdfundingplus> admins=crowfundingService.getsearch(1,(pageConf.getCurrentPage()-1)*pageConf.getPageSize(),pageConf.getPageSize(),search);


        for (Crowdfundingplus crowdfunding:admins){
            System.out.println(crowdfunding.getId());
        }
        System.out.println();
        result.put("total",count);
        result.put("admins",admins);
        return  result;

    }



}
