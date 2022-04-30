package com.xinjia.house.service.impl;

import com.xinjia.house.service.ImageSerice;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageSerice {
    // 文件保存的路径
    private String uploaddir = "F:\\桌面\\imgs";
    @Override
    public String uploadImage(MultipartFile mfile) {
        // 返回的信息
        String resultstr = "上传文件为空";
        if (mfile == null){
            return resultstr;
        }
        // 获取文件名，此处可以使用UUID进行重命名
        String originalFilename = mfile.getOriginalFilename();

        File uploadpath = new File(uploaddir);
        if (!uploadpath.exists()){
            // 如果目标文件夹不存在，先创建
            uploadpath.mkdirs();
        }
        // 开始写入文件
        File destfile = new File(uploadpath,originalFilename);
        try {
            mfile.transferTo(destfile);
            resultstr = "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultstr;
    }

    @Override
    public String uploadImages(MultipartFile[] files) {
        String resultstr = "上传文件为空";
        if (files == null) {
            return resultstr;
        }
        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            File uploadpath = new File(uploaddir);
            if (!uploadpath.exists()){
                uploadpath.mkdirs();
            }
            File destfile = new File(uploadpath,originalFilename);
            try {
                file.transferTo(destfile);
                resultstr = "上传成功";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return resultstr;
    }
}
