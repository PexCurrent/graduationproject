package cn.qingwei.graduationproject.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ReservationMapper {

    @Insert("insert into reservation(uid,cid) values(#{uid},#{cid})")
    public Integer insertreservation(int cid,int uid);


    @Delete("delete from reservation where uid=#{uid} and cid=#{cid}")
    public Integer delreservation(int cid,int uid);


}
