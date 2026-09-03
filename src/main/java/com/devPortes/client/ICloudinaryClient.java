package com.devPortes.client;

import org.springframework.web.multipart.MultipartFile;

public interface ICloudinaryClient {
    String saveImg(MultipartFile img);
}
