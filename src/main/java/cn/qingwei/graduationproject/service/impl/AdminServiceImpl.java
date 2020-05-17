package cn.qingwei.graduationproject.service.impl;

import cn.qingwei.graduationproject.mapper.Adminmapper;
import cn.qingwei.graduationproject.pojo.Admin;
import cn.qingwei.graduationproject.pojo.PageConf;
import cn.qingwei.graduationproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    Adminmapper adminmapper;
    @Override
    public Integer searchbyusernameandpassword(String username, String passowrd) {
        return adminmapper.searchbyusernameandpassword(username,passowrd);
    }

    @Override
    public Integer getadmincount() {
        return adminmapper.getadmincount();
    }

    @Override
    public List<Admin> getalladmins(int currentPage,int pageSize) {
//        currentpage 表示是第几页
        return adminmapper.getalladmins( (currentPage-1)*10,pageSize);
    }
}
