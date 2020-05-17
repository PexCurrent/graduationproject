package cn.qingwei.graduationproject.controller;

import cn.qingwei.graduationproject.mapper.Crowfundingmapper;
import cn.qingwei.graduationproject.pojo.Address;
import cn.qingwei.graduationproject.pojo.Crowdfunding;
import cn.qingwei.graduationproject.pojo.User;
import cn.qingwei.graduationproject.service.AddressService;
import cn.qingwei.graduationproject.service.CrowfundingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SupportController {
    @Autowired
    CrowfundingService crowfundingService;
    @Autowired
    AddressService addressService;

@RequestMapping("pay/{id}")
    public String gear_support(@PathVariable("id") int id, HttpServletRequest request){
    System.out.println(id+"_____");
//    Crowdfunding crowdfunding=crowfundingService.getCrowfundingbyId(id);
//    crowdfunding.setId(id);
//    System.out.println(crowdfunding);
//    modelMap.put("crowdfunding",crowdfunding);
    Crowdfunding crowdfunding=crowfundingService.getCrowfundingbyId(id);
    if (crowdfunding==null){
        return "index";
    }else {


    request.getSession().setAttribute("pay_cid",id);
    return "gear_support";
    }
}


    @RequestMapping("/getpayifo")
    @ResponseBody
    public Map<String,Object> gear_support(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result= new HashMap<>();
//        System.out.println("______");
//    Crowdfunding crowdfunding=crowfundingService.getCrowfundingbyId(id);
//    crowdfunding.setId(id);
//    System.out.println(crowdfunding);
//    modelMap.put("crowdfunding",crowdfunding);

       int crowdfundingid= (int) request.getSession().getAttribute("pay_cid");
//        System.out.println(crowdfundingid+"----------------");

       int user_id= (int) request.getSession().getAttribute("user_id");
       Crowdfunding crowdfunding=crowfundingService.getCrowfundingbyId(crowdfundingid);
//        System.out.println(crowdfunding);
       List<Address> addresses=addressService.getAddressByUserId(user_id);
//        System.out.println(addresses);
       Address defaultaddress=addressService.getDefaultAddressById(user_id);

       result.put("crowdfunding",crowdfunding);
       result.put("addresses",addresses);
       result.put("defaultaddress",defaultaddress);
//        System.out.println(result);
       return result;
    }

    @ResponseBody
    @RequestMapping("/pay/deladdress/{id}")
    public Map<String,Object> deladdress(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> result= new HashMap<>();

       int coun= addressService.delAddressById(id);
        if (coun!=1){
            result.put("msg","未知错误");
            result.put("status",false);
        }else {
            result.put("msg","你已经成功删除");
            result.put("status",true);
        }

        return result;




    }


    @RequestMapping("/pay/insertaddress")
    public  void insertaddress(Address address,HttpServletRequest request, HttpServletResponse response) throws IOException {
        int uid=(int)request.getSession().getAttribute("user_id");
        int crowdfundingid= (int) request.getSession().getAttribute("pay_cid");
        addressService.insertAddress(address,uid);




        response.sendRedirect("/pay/"+crowdfundingid);



    }

    @ResponseBody
    @RequestMapping("/pay/getedit")
    public Address getedit(HttpServletRequest request, HttpServletResponse response){

        System.out.println(addressService.getAddressById(( Integer.parseInt(request.getParameter("id")))));


        return addressService.getAddressById(( Integer.parseInt(request.getParameter("id"))));
    }

    @RequestMapping("/pay/updateaddress")
    public void updateaddress(Address address,HttpServletRequest request, HttpServletResponse response)throws IOException {
        System.out.println(address);
        System.out.println(addressService.updateAddress(address));
        int crowdfundingid= (int) request.getSession().getAttribute("pay_cid");
        response.sendRedirect("/pay/"+crowdfundingid);
    }

    @RequestMapping("pay/setdefaultaddress/{id}")

    public void setdefaultaddress(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println(addressService.qudefault());
        System.out.println(addressService.defaultaddress(id));

        int crowdfundingid= (int) request.getSession().getAttribute("pay_cid");
        response.sendRedirect("/pay/"+crowdfundingid);


    }

    @RequestMapping("freepay/{id}")

    public String freepay(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Crowdfunding crowdfunding = crowfundingService.getCrowfundingbyId(id);
        if (crowdfunding == null) {
            return "index";
        } else {

            request.getSession().setAttribute("payfree_cid", id);
            return "free_support";
        }
    }
    }
