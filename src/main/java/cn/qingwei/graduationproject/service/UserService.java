package cn.qingwei.graduationproject.service;

import cn.qingwei.graduationproject.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {

    public Integer getuserbyusername(@RequestParam(name = "username",required = false) String username);

    public User getuserbyid(@RequestParam(name = "id",required = false) int id);

    public Integer getuserbyemail(@RequestParam(name = "email",required = false) String email);

    public int insertUser(User user);

    public User getuserbyactiveCode(@RequestParam(name = "activeCode",required = false) String activeCode);

    public Integer updateUserbyid( @RequestBody User user);


    public User getUserbyusernameandpassword(@RequestParam("username")String username ,@RequestParam("password")String password);

    public User getUserisactive(@RequestParam("username")String username);

    public int editUser(@RequestBody User user,@RequestParam("id")int id);

    public int editacvtor(@RequestParam("acvtor") String acvtor,@RequestParam("id")int id);

    List<User> getalluser();

    List<User> getalluserbyname(String search);
    Integer activeuser(int id);

    List<String> getallnotifyemail(int cid);
    List<String> getnotifyemail(int cid);
}
