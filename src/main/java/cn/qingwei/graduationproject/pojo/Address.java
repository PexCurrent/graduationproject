package cn.qingwei.graduationproject.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Alias("Address")
@Component
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Address implements Serializable {
    private Integer id;
    private String receiver;   //收货人
    private  String theme;    //地址名称
    private String province;  //省
    private String city;      //市
    private  String district; //区/县
    private  String place;   //详细地址
    private  String mobile;   //可能会涉及区号 字符串类型的电话
    private boolean isdefault;



}
