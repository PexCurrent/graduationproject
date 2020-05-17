package cn.qingwei.graduationproject.mapper;

import cn.qingwei.graduationproject.pojo.Admin;
import cn.qingwei.graduationproject.pojo.PageConf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface Adminmapper {
    @Select("select count(1) from admin where username=#{username} and password=#{password}")
    Integer searchbyusernameandpassword(String username,String password);


    @Select("select * from admin limit #{currentPage},#{pageSize}")
    List<Admin> getalladmins(int currentPage,int pageSize);
    @Select("select count(1) from admin ")
    Integer getadmincount();
}
