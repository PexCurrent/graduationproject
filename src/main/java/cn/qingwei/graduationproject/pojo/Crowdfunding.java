package cn.qingwei.graduationproject.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Alias("Crowdfunding")
@Component
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Crowdfunding implements Serializable {
    private int id;
    private String title;   //标题
    private String Showpic; //图片
    private String content; //简介
    private int uid;
    private int freesupporttime;
    private int supporttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date begin_date;//开始日期


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date end_date;//结束日期
    private String details;
    private Integer targetamount;//目标金额
    private List<User> supportuser; //支持者 一个人只能支持一次 不能重复支持
    private String creatername;  //众筹建立者
    private Integer currentamout; //当前众筹金额
    private Status status;  //项目当前的状态
    private Gear gear;     //回报档位
    private  int reservationnum; //项目开始前的预约人数






}
