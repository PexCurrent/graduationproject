package cn.qingwei.graduationproject.mapper;

import cn.qingwei.graduationproject.pojo.Address;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import cn.qingwei.graduationproject.pojo.User ;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Mapper
public interface Usermapper {


    @Select("select * from user where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),

            @Result(property = "phonenum",column = "phonenum"),
            @Result(column="id",property="addresses",many=@Many(select="cn.qingwei.graduationproject.mapper.Addressmapper.getAddressByUserId",fetchType= FetchType.EAGER))
    })
    User getuserbyid(@Param("id") int id);

@Insert("insert into user(username,password,email,activeCode,isactive) values(#{username},#{password},#{email},#{activeCode},#{isactive})")
     int insertUser(User user);
     @Select("select count(1) from user where username=#{username}")
     Integer getuserbyusername(@Param("username") String username);

     @Select("select count(1) from user where email=#{email}")
     Integer getuserbyemail(@Param("email") String email);


@Select("select * from user where activeCode=#{activeCode}")
@Results({
        @Result(property = "id",column = "id"),

        @Result(property = "phonenum",column = "phonenum"),
        @Result(column="id",property="addresses",many=@Many(select="cn.qingwei.graduationproject.mapper.Addressmapper.getAddressByUserId",fetchType= FetchType.EAGER))
})
    public User getuserbyconfimcode(@Param("activeCode") String activeCode);


@Update("update user set username=#{username},password=#{password},phonenum=#{phonenum},acvtor=#{acvtor},email=#{email},isactive=#{isactive},activeCode=#{activeCode} where id=#{id}")

     public Integer updateUserbyid(User user);

     @Select("select * from user where username=#{username} and isactive=1")
     @Results({
             @Result(property = "id",column = "id"),

             @Result(property = "phonenum",column = "phonenum"),
             @Result(column="id",property="addresses",many=@Many(select="cn.qingwei.graduationproject.mapper.Addressmapper.getAddressByUserId",fetchType= FetchType.EAGER))
     })
        User getUserisactive(@Param("username") String username);


@Select("select * from user where username=#{username} and password=#{password}")
@Results({
        @Result(property = "id",column = "id"),

        @Result(property = "phonenum",column = "phonenum"),
        @Result(column="id",property="addresses",many=@Many(select="cn.qingwei.graduationproject.mapper.Addressmapper.getAddressByUserId",fetchType= FetchType.EAGER))
})
      User getUserbyusernameandpassword(@Param("username") String username, @Param("password") String password);


    @Update("update user set phonenum=#{user.phonenum},textArea=#{user.textArea},habitation=#{user.habitation},hometown=#{user.hometown} where id=#{id}")
    int editUser(@Param(value="user") User user, @Param("id") int id);
    @Update("update user set acvtor=#{acvtor} where id=#{id}")
    int editacvtor(@Param(value="acvtor") String acvtor, @Param("id") int id);

    @Select("select * from user")
     List<User> getalluser();
    @Select("select * from user where  username like   '%${search}%' ")
    List<User> getalluserbyname(String search);


    @Update("update user set isactive=1 where id=#{id}")
    Integer activeuser(int id);

    @Select("select email from user where id=any(select uid from crowdfungdingorder where cid=#{cid})")
    List<String> getallnotifyemail(int cid);

    @Select("select email from user where id=any(select uid from reservation where cid=#{cid})")
    List<String> getnotifyemail(int cid);
}
