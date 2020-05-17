package cn.qingwei.graduationproject.mapper;

import cn.qingwei.graduationproject.pojo.Crowdfunding;
import cn.qingwei.graduationproject.pojo.Gear;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface GearMapper {

    @Insert("insert into gear(release_year,release_month,way,cid,gearimg,title,introduction,supportAmount) values(#{release_year},#{release_month},#{way},#{cid},#{gearimg},#{title},#{introduction},#{supportAmount})")
    @Options(useGeneratedKeys=true,keyProperty = "id",keyColumn = "id")
    public Integer insertgear(Gear gear);

    @Select("select * from gear where cid=#{cid}")
    public Gear getGearbyID(int cid);

    @Delete("delete from gear where cid=#{cid}")
    public Integer deletegearbyuid(int cid);



}
