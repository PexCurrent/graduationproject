package cn.qingwei.graduationproject.service.impl;

import cn.qingwei.graduationproject.mapper.CommentMapper;
import cn.qingwei.graduationproject.pojo.Comment;
import cn.qingwei.graduationproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public Integer fabiao(int uid, int cid, String comment_msg) {
        return commentMapper.fabiao(uid,cid,comment_msg);
    }

    @Override
    public List<Comment> getcomment(int cid) {
        return commentMapper.getcomment(cid);
    }
}
