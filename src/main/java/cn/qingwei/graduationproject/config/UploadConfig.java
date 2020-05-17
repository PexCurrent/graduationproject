package cn.qingwei.graduationproject.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class UploadConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//映射图片保存地址
        registry.addResourceHandler("/upload/**").addResourceLocations("file:G:\\IdeaWorkSpace\\graduationproject\\src\\main\\resources\\static\\upload\\");
    }
}
