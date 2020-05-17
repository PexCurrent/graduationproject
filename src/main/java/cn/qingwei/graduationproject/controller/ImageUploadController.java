package cn.qingwei.graduationproject.controller;

import cn.qingwei.graduationproject.pojo.ImageUploadVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/images")
@Slf4j
public class ImageUploadController {

//    private final String imageFilePath = "E:/test/";

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping("/ckeditorUpload")
    public ImageUploadVo ckeditorUpload(@RequestParam("upload") MultipartFile file) throws Exception {
            String imageFilePath= ResourceUtils.getURL("classpath:static").getPath()+"/upload/";
        System.out.println(imageFilePath);
        log.info("开始上传图片");
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + suffixName;
        log.info("上传文件文件名称：{}",newFileName);
        log.info("上传文件大小 ：{}" + file.getSize());
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imageFilePath + newFileName));

        ImageUploadVo imageUploadVo = new ImageUploadVo();
        imageUploadVo.setUploaded(1);
        imageUploadVo.setFileName(newFileName);
        System.out.println(imageFilePath + newFileName);
        imageUploadVo.setUrl("http://localhost:8800/upload/"+newFileName);
        return imageUploadVo;
    }










}

