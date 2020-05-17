package cn.qingwei.graduationproject.controller;

import cn.qingwei.graduationproject.service.UserService;
import cn.qingwei.graduationproject.utils.CommonUtils;
import cn.qingwei.graduationproject.vo.AjaxResult;
import cn.qingwei.graduationproject.vo.CrowfundingGraphicData;
import cn.qingwei.graduationproject.vo.GraphicData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.sun.deploy.net.HttpResponse;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Pattern;

@Controller

public class IndexController {



    @Autowired
    UserService userService;
    @RequestMapping("/imgupload")
    @ResponseBody
    public AjaxResult upload(@RequestParam(value = "avatar_file", required = false) MultipartFile file,
                             @RequestParam("avatar_data") String avatar_data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(avatar_data);
        System.out.println(file.getName());

        //获得裁剪数据
//        GraphicData graphicData = JSONPObject.parseObject(avatar_data, GraphicData.class);
        GraphicData graphicData = JSONObject.parseObject(avatar_data,GraphicData.class);
        //获得文件名
        System.out.println(ResourceUtils.getURL("classpath:static").getPath()+"/upload");
        String fileName = file.getOriginalFilename();
        //获取扩展名
        String extension = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(graphicData.getH());
        System.out.println(graphicData.getW());
        //检测允许上传的文件类型
        if (!Pattern.matches("\\.(jpg|jpeg|png|gif)$", extension)) {
            return new AjaxResult(false, "文件类型不允许");
        }
        //根据日期生成保存路径
        String folderPath = "/upload/";

//        String realFolderPath =ResourceUtils.getURL("classpath:static").getPath()+folderPath;
//        String realFolderPath ="G:/IdeaWorkSpace/graduationproject/src/main/resources/static/upload/";\
        String realFolderPath=ResourceUtils.getURL("classpath:static").getPath()+"/upload";
        System.out.println(realFolderPath+"{{}}");
        File savedPath = new File(realFolderPath);
        //路径不存在则创建
        if (!savedPath.exists()) {
            savedPath.mkdir();
        }
        //设置裁剪后的突破大小
        int width = 180;
        int height = 180;
//        savedFileName 文件名称命名
        String savedFileName = UUID.randomUUID().toString() + extension;
        File savedFile = new File(realFolderPath, savedFileName);
        System.out.println(savedFile);
        //裁剪图片并保存
        Thumbnails.of(file.getInputStream()).sourceRegion(graphicData.getX(), graphicData.getY(),
                graphicData.getW(), graphicData.getH()).size(width, height).toFile(savedFile);
        //保存新的url到session
        request.getSession().setAttribute("url", folderPath + savedFileName);
        userService.editacvtor(folderPath + savedFileName,(int)request.getSession().getAttribute("user_id"));

        return new AjaxResult(true, "图片上传成功", folderPath + savedFileName);
    }




    @RequestMapping("/crowdfundingimgupload")
    @ResponseBody
    public AjaxResult crowdfundingimgupload(@RequestParam(value = "avatar_file", required = false) MultipartFile file,
                             @RequestParam("avatar_data") String avatar_data, HttpServletRequest request, HttpServletResponse response) throws IOException {


        System.out.println(avatar_data);
        System.out.println(file.getSize());
        System.out.println(file.getOriginalFilename());

        //获得裁剪数据
//        GraphicData graphicData = JSONPObject.parseObject(avatar_data, GraphicData.class);
        CrowfundingGraphicData graphicData = JSONObject.parseObject(avatar_data,CrowfundingGraphicData.class);
        System.out.println(graphicData.getHeight());
        System.out.println(graphicData.getWidth());

        //获得文件名
        System.out.println(ResourceUtils.getURL("classpath:static").getPath()+"/upload");
        String fileName = file.getOriginalFilename();
        //获取扩展名
        String extension = fileName.substring(fileName.lastIndexOf("."));
        //检测允许上传的文件类型
        if (!Pattern.matches("\\.(jpg|jpeg|png|gif)$", extension)) {
            return new AjaxResult(false, "文件类型不允许");
        }
        //根据日期生成保存路径
        String folderPath = "/upload/";

//        String realFolderPath =ResourceUtils.getURL("classpath:static").getPath()+folderPath;
//        String realFolderPath ="G:/IdeaWorkSpace/graduationproject/src/main/resources/static/upload/";\
        String realFolderPath=ResourceUtils.getURL("classpath:static").getPath()+"/upload";
        System.out.println(realFolderPath+"{{}}");
        File savedPath = new File(realFolderPath);
        //路径不存在则创建
        if (!savedPath.exists()) {
            savedPath.mkdir();
        }
        int width = 180;
        int height = 180;
//        savedFileName 文件名称命名
        String savedFileName = UUID.randomUUID().toString() + extension;
        File savedFile = new File(realFolderPath, savedFileName);
        System.out.println(savedFile);
        //裁剪图片并保存
        Thumbnails.of(file.getInputStream()).sourceRegion(graphicData.getX(), graphicData.getY(),
                graphicData.getWidth(), graphicData.getHeight()).size(width, height).toFile(savedFile);
        //保存新的url到session
        request.getSession().setAttribute("imgurl", folderPath + savedFileName);


        return new AjaxResult(true, "图片上传成功", folderPath + savedFileName);
    }
}

