package com.itheima.controller;


import com.fasterxml.jackson.databind.ser.std.FileSerializer;
import com.itheima.util.UploadUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/springmvc")
public class FileUploadController {
    private static final String FILESERVERURL ="http://localhost:8088/upload/" ;

    @RequestMapping("/fileUpload02")
    public String fileUpload02(HttpServletRequest request, String pdesc, MultipartFile upload) throws IOException {
        System.out.println("pdesc="+pdesc);
        //1. 获得文件名
        String originalFilename = upload.getOriginalFilename();
        //2. 获得随机文件名
        String uuidName = UploadUtils.getUUIDName(originalFilename);
        //3. 获得绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        //4. 获得两层目录
        String dir = UploadUtils.getDir();
        //5.创建两层目录
        File file = new File(realPath, dir);
        if (!file.exists()){
            file.mkdirs();
        }
        //6.使用 MulitpartFile 接口中方法，把上传的文件写到指定位置
        upload.transferTo(new File(file, uuidName));


         return "success";
    }
    @RequestMapping("/fileUpload03")
    public String fileUpload03(String pdesc,MultipartFile upload) throws IOException {
        System.out.println("pdesc="+pdesc);
        //1. 获得文件名
        String originalFilename = upload.getOriginalFilename();
        //2. 获得随机文件名
        String uuidName = UploadUtils.getUUIDName(originalFilename);
        //3.创建jersey包中提供的client对象
        Client client = Client.create();//它就可以和文件服务器建立联系
        //4.使用client和文件服务器建立联系
        WebResource resource = client.resource(FILESERVERURL + uuidName);
        //5.把web资源对象写到文件服务器
        resource.put(upload.getBytes());
        return "success";
    }

}
