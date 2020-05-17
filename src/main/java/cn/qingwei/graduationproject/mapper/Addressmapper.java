package cn.qingwei.graduationproject.mapper;

import cn.qingwei.graduationproject.pojo.User;
import org.apache.ibatis.annotations.*;
import cn.qingwei.graduationproject.pojo.Address;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@Mapper
public interface Addressmapper {




    @Select("select * from address where uid=#{uid}")
    public List<Address> getAddressByUserId(int uid);


    @Select("select * from address where uid=#{uid} and isdefault=1")
    Address getDefaultAddressById(int id);

    @Select("select * from address where id=#{id}")
    public Address getAddressById(int id);

    @Delete("delete  from address where id=#{id}")
    public int delAddressById(int id);




//    @Insert("insert into address(uid,theme,province,city,district,place,mobile,receiver) values (#{uid},#{theme},#{province},#{city},#{district},#{place},#{mobile}),#{receiver})")
//    int insertAddress(@RequestBody  Address address,@Param("uid") int uid);
//
//
//
//    @Insert("insert into address(theme,province,city,district,place,mobile,receiver) values (#{theme},#{province},#{city},#{district},#{place},#{mobile},#{receiver})")
//    int test(@RequestBody  Address address);


    @Insert("insert into address(uid,theme,province,city,district,place,mobile,receiver) values (#{uid},#{address.theme},#{address.province},#{address.city},#{address.district},#{address.place},#{address.mobile},#{address.receiver})")
    int insertAddress(@Param(value="address")  Address address,@Param("uid") int uid);

    @Update("update address set receiver=#{receiver},theme=#{theme},province=#{province},city=#{city},district=#{district},place=#{place},mobile=#{mobile} where id=#{id}")
    int updateAddress(Address address);
    @Update("update address set isdefault=0 where isdefault=1")
    int qudefault();
    @Update("update address set isdefault=1 where id=#{id}")
    int defaultaddress(int id);
}
