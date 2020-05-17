package cn.qingwei.graduationproject.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Alias("Crowdfunding")
@Component
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Comment {
  private int id; //主键id
  private  String username;
  private String acvtor;
  private int uid;
  private  int cid;
  private  int pid;  //父id  如果为0，则说明为首评论 不能为0;
  private  String comment_msg;  //回复内容;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date create_time; //创建时间


}
