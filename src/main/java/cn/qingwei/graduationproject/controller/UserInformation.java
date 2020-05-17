package cn.qingwei.graduationproject.controller;

import cn.qingwei.graduationproject.pojo.Address;
import cn.qingwei.graduationproject.pojo.Habitation;
import cn.qingwei.graduationproject.pojo.Hometown;
import cn.qingwei.graduationproject.pojo.User;
import cn.qingwei.graduationproject.service.AddressService;
import cn.qingwei.graduationproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserInformation {
    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;
    @RequestMapping("/useredit")
    public  String useredit(){
        return "useredit";
    }

    @RequestMapping("/addressedit")
    public String address(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        int user_id=(Integer) request.getSession().getAttribute("user_id");
//        User user=userService.getuserbyid(user_id);
//        System.out.println(user);
//        request.setAttribute("User",user);

        return "address";
    }
    @ResponseBody
    @RequestMapping("/getressedit")
    public User getaddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int user_id=(Integer) request.getSession().getAttribute("user_id");
        User user=userService.getuserbyid(user_id);
        System.out.println(user);
        System.out.println("___UUU__");
        return user;
    }

    @ResponseBody
    @RequestMapping("/getedit")
    public Address getedit(HttpServletRequest request, HttpServletResponse response){

        System.out.println(addressService.getAddressById(( Integer.parseInt(request.getParameter("id")))));


        return addressService.getAddressById(( Integer.parseInt(request.getParameter("id"))));
    }

    @ResponseBody
    @RequestMapping("/deladdress/{id}")
    public void deladdress(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println(addressService.delAddressById(id));

        response.sendRedirect("/addressedit");


    }

    @RequestMapping("/insertaddress")
    public  void insertaddress(Address address,HttpServletRequest request, HttpServletResponse response) throws IOException {
        int uid=(int)request.getSession().getAttribute("user_id");


        System.out.println(address);

        System.out.println(addressService.insertAddress(address,uid));
        response.sendRedirect("/addressedit");



    }
@RequestMapping("/updateaddress")
public void updateaddress(Address address,HttpServletRequest request, HttpServletResponse response)throws IOException{
        System.out.println(addressService.updateAddress(address));
    response.sendRedirect("/addressedit");
}


@RequestMapping("/setdefaultaddress/{id}")

public void setdefaultaddress(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) throws IOException {

    System.out.println(addressService.qudefault());
    System.out.println(addressService.defaultaddress(id));

    response.sendRedirect("/addressedit");


}

    @RequestMapping("/getuserbyid")
    @ResponseBody
public User getuserbyid(HttpServletRequest request, HttpServletResponse response){
       int id= (int) request.getSession().getAttribute("user_id");
    return userService.getuserbyid(id);

}

    @RequestMapping("/edituser")
    @ResponseBody
    public void edituser(@ModelAttribute("user") User user, @ModelAttribute("habitation") Habitation habitation , @ModelAttribute("hometown") Hometown hometown, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(habitation);
        System.out.println(hometown);
        System.out.println(user);
        user.setHometown(hometown.toString());
        user.setHabitation(habitation.toString());
        int id=(int)request.getSession().getAttribute("user_id");

        System.out.println(userService.editUser(user,id));
        response.sendRedirect("/useredit");


    }

    @InitBinder("user")
    public void initBinderUser(WebDataBinder binder){
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("habitation")
    public void initBinderHabitation(WebDataBinder binder){
        binder.setFieldDefaultPrefix("habitation.");
    }
    @InitBinder("hometown")
    public void initBinderHometown(WebDataBinder binder){
        binder.setFieldDefaultPrefix("hometown.");
    }
}
