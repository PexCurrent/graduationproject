package cn.qingwei.graduationproject.controller;

import cn.qingwei.graduationproject.pojo.Order;
import cn.qingwei.graduationproject.pojo.OrderStatusCount;
import cn.qingwei.graduationproject.service.CrowfundingService;
import cn.qingwei.graduationproject.service.OrderService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
public class OrderContoller {
    @Autowired
    CrowfundingService crowfundingService;
    @Autowired
    OrderService orderService;


    @RequestMapping("/getmyorderbyuid")
    @ResponseBody
    public Map<String,Object> getmyorderbyuid(HttpServletRequest request, HttpServletResponse response){
         Map<String,Object> result=new HashMap<>();
         int user_id=(int)request.getSession().getAttribute("user_id");
        OrderStatusCount orderStatusCount=orderService.StatusordercountbyUId(user_id);
        List<Order> orders=orderService.getOrderbyid(user_id);
        List<Order> shippingorders=orderService.getOrderkindbyid(user_id,0);
        List<Order> receivingorders=orderService.getOrderkindbyid(user_id,1);
        List<Order> completedorders=orderService.getOrderkindbyid(user_id,2);
        List<Order> refundingorders=orderService.getOrderkindbyid(user_id,3);
        List<Order> refundedorders=orderService.getOrderkindbyid(user_id,4);

        result.put("orderStatusCount",orderStatusCount);
        result.put("orders",orders);
        result.put("shippingorders",shippingorders);
        result.put("receivingorders",receivingorders);
        result.put("completedorders",completedorders);
        result.put("refundingorders",refundingorders);
        result.put("refundedorders",refundedorders);



         return result;
    }


    @RequestMapping("/getorderdetail")
    @ResponseBody
    public Map<String,Object> getorderdetail(String id,HttpServletRequest request, HttpServletResponse response){
       Order order=orderService.getOrderbyoid(id);
       Map<String,Object> result=new HashMap<>();
       result.put("order",order);

return result;

    }

    @RequestMapping("/orderrefund")
    @ResponseBody
    public Map<String,Object> refund(String oid,HttpServletRequest request, HttpServletResponse response){
        System.out.println(oid);
        Map<String,Object> result=new HashMap<>();
        if (orderService.changeorderstatus(3,oid)!=0){
            result.put("status",1);
            result.put("msg","已经发送退款请求");
        }else {
            result.put("status",0);
            result.put("msg","请求失败");
        }

        return  result;

    }
    @RequestMapping("/cancelrefund")
    @ResponseBody
    public Map<String,Object> cancelrefund(String oid,HttpServletRequest request, HttpServletResponse response){
        System.out.println(oid);
        Map<String,Object> result=new HashMap<>();
        if (orderService.changeorderstatus(1,oid)!=0){
            result.put("status",1);
            result.put("msg","已经取消退款请求,默认变更为发货状态，不可在退款");
        }else {
            result.put("status",0);
            result.put("msg","请求失败");
        }

        return  result;

    }

    @RequestMapping("/confirmitem")
    @ResponseBody
    public Map<String,Object> confirmitem(String oid,HttpServletRequest request, HttpServletResponse response){
        System.out.println(oid);
        Map<String,Object> result=new HashMap<>();
        if (orderService.changeorderstatus(2,oid)!=0){
            result.put("status",1);
            result.put("msg","已经确认收货");
        }else {
            result.put("status",0);
            result.put("msg","请求失败");
        }

        return  result;

    }
    @RequestMapping("/getorder")
    @ResponseBody
    public Map<String,Object> getorder(String oid,HttpServletRequest request, HttpServletResponse response){
        System.out.println(oid);
        Map<String,Object> result=new HashMap<>();
        Order order=orderService.getOrderbyoid(oid);
        result.put("order",order);
        return  result;



    }

    @RequestMapping("/editorderinfo")
    @ResponseBody
    public Map<String,Object> editorderinfo(String oid,String receiver,String address,String mobile, HttpServletRequest request, HttpServletResponse response){
        System.out.println(oid);


        System.out.println("____");
        Map<String,Object> result=new HashMap<>();
        if (orderService.editorderaddress(oid,receiver,address,mobile)!=0){
            result.put("status",1);
            result.put("msg","已经更改地址信息");
        }else {
            result.put("status",0);
            result.put("msg","请求失败");
        }

        return  result;

    }




}
