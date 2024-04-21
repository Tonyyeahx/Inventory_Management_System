package com.uw.cs506.team03.smartstock.service;

import org.springframework.web.multipart.MultipartFile;

import com.uw.cs506.team03.smartstock.entity.Image;

public interface ImageService {
    Image saveImage(MultipartFile file);
    Image getImage(Long id);
}