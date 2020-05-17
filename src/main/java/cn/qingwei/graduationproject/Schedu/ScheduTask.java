package cn.qingwei.graduationproject.Schedu;

import cn.qingwei.graduationproject.pojo.Crowdfunding;
import cn.qingwei.graduationproject.service.CrowfundingService;
import cn.qingwei.graduationproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Configuration     //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling  // 2.开启定时任务
public class ScheduTask {
    @Autowired
    CrowfundingService crowfundingService;

    @Autowired
    UserService userService;

    @Autowired
    JavaMailSenderImpl mailSender;
    /**
     * 每天凌晨执行一次
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void updatecrowdfundings(){
        List<Crowdfunding> finishcrowdfundings=crowfundingService.finishCrowfundings();
        if(finishcrowdfundings!=null){
            for (Crowdfunding crowdfunding:finishcrowdfundings){
                  if (crowdfunding.getCurrentamout()>=crowdfunding.getTargetamount())
                      crowfundingService.updateCrowfundingstauts(crowdfunding.getId(),3);
                  else
                      crowfundingService.updateCrowfundingstauts(crowdfunding.getId(),4);

            }
        }


    }


    @Scheduled(cron = "0 0 0 * * ?")
    public void notifyreservation(){
        List<Crowdfunding> notifycrowdfunding=crowfundingService.notifyreservation();
        if(notifycrowdfunding!=null){
            for (Crowdfunding crowdfunding:notifycrowdfunding){
                List<String> emails=userService.getnotifyemail(crowdfunding.getId());
                String title=crowdfunding.getTitle()+"已经正式开始众筹";
                String msg= "<a href='/Crowdfunding/"+crowdfunding.getId()+"'>"+"项目详情"+   "</a>";


                String newmsg="你的项目已经开始点击<a href='http://localhost:8800/Crowdfunding/\"+crowdfunding.getId()+\"'>项目</a>开始预约\", \"text/html;charset=GBK\"";
                try {
                    sentemail(emails,newmsg,title);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }


    }


//    @Scheduled(fixedRate=5000)
    public void notifyreservation2(){
        System.out.println("sss");
        List<Crowdfunding> notifycrowdfunding=crowfundingService.notifyreservation();
        if(notifycrowdfunding!=null){
            for (Crowdfunding crowdfunding:notifycrowdfunding){
                List<String> emails=userService.getnotifyemail(crowdfunding.getId());
                String title=crowdfunding.getTitle()+"已经正式开始众筹";


                String msg= "<html>" +
                            "<body>" +
                           "<BR>" +
                            "<div align='center'>" +
                            "<BR>" +
                           "<h4>" +
                           "你的项目已经开始点击" +
                           "<a href='http://localhost:8800/Crowdfunding/\"+crowdfunding.getId()+\"'>项目</a>" +
                        "开始预约"+
                            "</h4>" +
                            "</div>" +
                            "</body>" +
                            "</html>";


                try {
                    sentemail(emails,msg,title);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }


    }


    public void sentemail(List<String> emails,  String msg,String title)throws Exception{

        for (String email:emails){

            SimpleMailMessage message = new SimpleMailMessage();
            JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

            //设定mail server
            senderImpl.setHost("smtp.163.com");

            //建立邮件消息,发送简单邮件和html邮件的区别
            MimeMessage mailMessage = senderImpl.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true, "utf-8");

            //设置收件人，寄件人
            messageHelper.setTo(email);
            messageHelper.setFrom("17803865542@163.com");
            messageHelper.setSubject("你在Pex众筹参与的项目--"+title+"有了一则更新");
            //true 表示启动HTML格式的邮件
            messageHelper.setText(msg,true);

            senderImpl.setUsername("17803865542@163.com") ; // 根据自己的情况,设置username
            senderImpl.setPassword("chenqaz19980128") ; // 根据自己的情况, 设置password

            //发送邮件
            senderImpl.send(mailMessage);

            System.out.println("邮件发送成功..");








//            message.setSubject("你在Pex众筹参与的项目--"+title+"有了一则更新");
//
//            message.setText(msg);
//
//            message.setTo(email);
//            message.setFrom("17803865542@163.com");
//
//            mailSender.send(message);
        }

    }



    public void sentemail2(String msg){



            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("你在Pex众筹参与的项目--有了一则更新");

            message.setText(msg);
            message.setTo("924451763@qq.com");
            message.setFrom("17803865542@163.com");
            mailSender.send(message);


    }
}
