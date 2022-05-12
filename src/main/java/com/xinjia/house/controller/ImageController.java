package com.xinjia.house.controller;

import com.xinjia.house.service.ImageService;
import com.xinjia.house.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

@Api(tags = "图片处理器")
@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;

    @ApiOperation("获取base64图片")
    @RequestMapping(value = "/getImage", method = RequestMethod.POST)
    public Result<String> getImage(@RequestBody String path) throws IOException {
        return Result.success(200, "成功", ImageToBase64(path));
    }

    @ApiOperation("上传图片")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadImage(@RequestPart MultipartFile mfile) {
        return imageService.uploadImage(mfile);
    }

    public String ImageToBase64(String path) throws IOException {
        String path1 = "E:/imgs/" + path;
        System.out.println("4564897");
        FileInputStream fileInputStream = new FileInputStream(path1);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len = -1;

        while ((len = fileInputStream.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        byte[] fileByte = bos.toByteArray();
        // 进行base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(fileByte);
    }

}
