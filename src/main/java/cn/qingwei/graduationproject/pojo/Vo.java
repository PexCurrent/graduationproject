package cn.qingwei.graduationproject.pojo;

import lombok.Data;

@Data
public class Vo {
    /**响应编码*/
    private int code=0;
    /**响应消息*/
    private String msg="";
    /**数据总量*/
    private int count;
    /**数据*/
    private Object data;
}
