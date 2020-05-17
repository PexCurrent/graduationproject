package cn.qingwei.graduationproject.mapper;

import cn.qingwei.graduationproject.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CommentMapper {

    @Insert("insert into comment (uid,cid,comment_msg,create_time) value (#{uid},#{cid},#{comment_msg},now())")
    Integer fabiao(int uid,int cid,String comment_msg);

    @Select("select comment.*,user.username,user.acvtor from comment,user where comment.cid=#{cid} and comment.uid=user.id ORDER BY `comment`.create_time desc")
    List<Comment> getcomment(int cid);


}
