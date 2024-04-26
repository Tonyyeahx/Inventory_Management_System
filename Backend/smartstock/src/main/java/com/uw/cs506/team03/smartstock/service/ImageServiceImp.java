package com.uw.cs506.team03.smartstock.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.uw.cs506.team03.smartstock.entity.Image;
import com.uw.cs506.team03.smartstock.repository.ImageRepository;

/**
 * This class is the service for the image table
 */
@Service
public class ImageServiceImp implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    /**
     * This is the default constructor for the ImageServiceImp class
     */
    public ImageServiceImp() {
    }

    /**
     * This method is used to save an image
     * @param file the image file
     * @return the saved image
     */
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

    /**
     * This method is used to get an image by its id
     * @param id the id of the image
     * @return the image
     */
    @Override
    public Image getImage(Long id) {
        return imageRepository.findById(id).get();
    }
}
