package cn.qingwei.graduationproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {


    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/nav").setViewName("nav");
        registry.addViewController("/mycrowdfunding").setViewName("mycrowdfunding");
        registry.addViewController("/myorder").setViewName("myorder");
        registry.addViewController("/index").setViewName("index");
//
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/emp/**","/main.html").excludePathPatterns("/index.html");

        InterceptorRegistration ir=registry.addInterceptor(new LoginInterceptor());
        ir.addPathPatterns("/mycrowdfunding");
        ir.addPathPatterns("/myorder");
        ir.addPathPatterns("/useredit");
        ir.addPathPatterns("/addressedit");
        ir.addPathPatterns("/release");
        ir.addPathPatterns("/freepay/*");
        ir.addPathPatterns("/pay/*");
        ir.addPathPatterns("/all/**");
        ir.addPathPatterns("/reservation/**");
        ir.addPathPatterns("/Crowdfunding/**");


    }


}
