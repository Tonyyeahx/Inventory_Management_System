package com.uw.cs506.team03.smartstock.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.uw.cs506.team03.smartstock.entity.Image;
import com.uw.cs506.team03.smartstock.repository.ImageRepository;

@Service
// This class is used to implement the ImageService interface
public class ImageServiceImp implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    // Save image to database
    @Override
    public Image saveImage(MultipartFile file) {
        Image image = new Image();
        try {
            image.setData(file.getBytes());
            imageRepository.save(image);
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get image from database
    @Override
    public Image getImage(Long id) {
        return imageRepository.findById(id).get();
    }
}
