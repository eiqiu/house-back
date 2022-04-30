package com.xinjia.house.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageSerice {
    String uploadImage(MultipartFile mfile);
    String uploadImages(MultipartFile[] files);
}
