package cn.qingwei.graduationproject.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Data
@Alias("admin")
@Component
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Admin {
    private String username;
    private  String password;
}
