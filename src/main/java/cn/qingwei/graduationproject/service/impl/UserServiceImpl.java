package cn.qingwei.graduationproject.service.impl;

import cn.qingwei.graduationproject.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import cn.qingwei.graduationproject.service.UserService;
import cn.qingwei.graduationproject.mapper.Usermapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Usermapper mapper;

    @Override
    public List<String> getallnotifyemail(int cid) {
        return mapper.getallnotifyemail(cid);
    }

    @Override
    public Integer getuserbyusername(String username) {
        return mapper.getuserbyusername(username);
    }

    @Override
    public User getuserbyid(int id) {
        return mapper.getuserbyid(id);
    }

    @Override
    public Integer getuserbyemail(String email) {
        return mapper.getuserbyemail(email);
    }

    @Override
    public int insertUser(User user) {
        return mapper.insertUser(user);
    }

    @Override
    public User getuserbyactiveCode(String activeCode) {
        return mapper.getuserbyconfimcode(activeCode);
    }

    @Override
    public Integer updateUserbyid(User user) {
        return mapper.updateUserbyid(user);
    }

    @Override
    public User getUserbyusernameandpassword(String username, String password) {
        return mapper.getUserbyusernameandpassword(username,password);
    }

    @Override
    public User getUserisactive(String username) {
        return mapper.getUserisactive(username);
    }

    @Override
    public int editUser(User user, int id) {
        return mapper.editUser(user,id);
    }

    @Override
    public int editacvtor(String acvtor, int id) {
        return mapper.editacvtor(acvtor,id);
    }

    @Override
    public List<User> getalluser() {
        return mapper.getalluser();
    }

    @Override
    public Integer activeuser(int id) {
        return mapper.activeuser(id);
    }

    @Override
    public List<User> getalluserbyname(String search) {
        return mapper.getalluserbyname(search);
    }

    @Override
    public List<String> getnotifyemail(int cid) {
        return mapper.getnotifyemail(cid);
    }
}
