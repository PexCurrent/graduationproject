package cn.qingwei.graduationproject.pojo;

//import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

@Data
@Alias("user")
@Component
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })


//发现是实体类中有的字段值为null，所以在json化的时候，fasterxml.jackson将对象转换为json报错
//在实体类上面加上注解 @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String phonenum;
    private String acvtor;
//    private SexEnum sex;
    private String email;
    private String textArea;
    private Integer isactive=0;
    private String activeCode;
    private  String id_captcha;
    private String habitation;  //居住地
    private String hometown;     //家乡


    private List<Address> addresses;



}
