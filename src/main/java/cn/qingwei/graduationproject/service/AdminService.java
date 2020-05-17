package cn.qingwei.graduationproject.service;

import cn.qingwei.graduationproject.pojo.Admin;
import cn.qingwei.graduationproject.pojo.PageConf;

import java.util.List;

public interface AdminService {
    Integer searchbyusernameandpassword(String username,String passowrd);
    List<Admin> getalladmins(int currentPage,int pageSize);
    Integer getadmincount();

}
