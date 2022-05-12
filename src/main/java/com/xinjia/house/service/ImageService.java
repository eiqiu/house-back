package com.xinjia.house.service;

import com.xinjia.house.pojo.HousePicture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    String uploadImage(MultipartFile mfile);

    void uploadImages(MultipartFile[] files);

    void saveImages(List<HousePicture> pictures);

    void modifyImages(MultipartFile[] files, int house_id);
}
