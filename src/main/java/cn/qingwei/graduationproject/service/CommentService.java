package cn.qingwei.graduationproject.service;

import cn.qingwei.graduationproject.pojo.Comment;

import java.util.List;

public interface CommentService {
    Integer fabiao(int uid,int cid,String comment_msg);
    List<Comment> getcomment(int cid);
}
