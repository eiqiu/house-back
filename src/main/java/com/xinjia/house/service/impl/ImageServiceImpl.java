package com.xinjia.house.service.impl;

import com.xinjia.house.dao.ImageDao;
import com.xinjia.house.pojo.HousePicture;
import com.xinjia.house.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;
    // 文件保存的路径
    private String uploaddir = "F:\\桌面\\BackAndFront\\house-back\\src\\main\\resources\\static";

    //　上传单张图片
    @Override
    public String uploadImage(MultipartFile mfile) {
        // 返回的信息
        String resultstr = "上传文件为空";
        if (mfile == null) {
            return resultstr;
        }
        // 获取文件名，此处可以使用UUID进行重命名
        String originalFilename = mfile.getOriginalFilename();

        File uploadpath = new File(uploaddir);
        if (!uploadpath.exists()) {
            // 如果目标文件夹不存在，先创建
            uploadpath.mkdirs();
        }
        // 开始写入文件
        File destfile = new File(uploadpath, originalFilename);
        try {
            mfile.transferTo(destfile);
            resultstr = "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultstr;
    }

    // 用于发布房子上传图片
    @Override
    public void uploadImages(MultipartFile[] files) {
        int house_id = imageDao.getLastHouseId();
        List<HousePicture> pictures = new ArrayList<HousePicture>();
        if (files == null) {
            return;
        }
        // 保存至本地
        for (MultipartFile file : files) {
            String fileName = UUID.randomUUID().toString();
            String originalFilename = file.getOriginalFilename();
            String type = originalFilename.substring(originalFilename.lastIndexOf("."));
            fileName += type;
//            System.out.println(fileName);
            HousePicture housePicture = new HousePicture(0, house_id, fileName);
            pictures.add(housePicture);
            File uploadpath = new File(uploaddir);
            if (!uploadpath.exists()) {
                uploadpath.mkdirs();
            }
            File destfile = new File(uploadpath, fileName);
            try {
                file.transferTo(destfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 路径保存至数据库
        this.saveImages(pictures);
    }

    // 发布房子保存图片路径至数据库
    @Override
    public void saveImages(List<HousePicture> pictures) {
        imageDao.addHousePictures(pictures);
    }

    // 修改图片
    @Override
    public void modifyImages(MultipartFile[] files, int house_id) {
        this.deleteImages(house_id);
        List<HousePicture> pictures = new ArrayList<HousePicture>();
        String resultstr = "上传文件为空";
        if (files == null) {
            return;
        }
        // 保存至本地
        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            HousePicture housePicture = new HousePicture(0, house_id, originalFilename);
            pictures.add(housePicture);
            File uploadpath = new File(uploaddir);
            if (!uploadpath.exists()) {
                uploadpath.mkdirs();
            }
            File destfile = new File(uploadpath, originalFilename);
            try {
                file.transferTo(destfile);
                resultstr = "上传成功";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 路径保存至数据库
        this.saveImages(pictures);
    }

    public void deleteImages(int house_id) {
        imageDao.deleteHousePictures(house_id);
    }
}
