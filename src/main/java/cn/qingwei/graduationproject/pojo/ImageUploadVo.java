package cn.qingwei.graduationproject.pojo;

import lombok.Data;

/**
 * Created by wangchen on 2019/10/16 15:18
 * Description: 上传图片返回信息 CKEditor需要返回json信息
 * uploaded 在上传成功时可以设置为1 失败为 0
 * fileName 为文件名
 * url 为文件的实际访问路径
 */
@Data
public class ImageUploadVo {
    private int uploaded;
    private String fileName;
    private String url;

}

