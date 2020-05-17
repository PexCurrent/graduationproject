package cn.qingwei.graduationproject.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PageConf {
    private  int pageSize;
    private int currentPage;
    private String rule;
}
