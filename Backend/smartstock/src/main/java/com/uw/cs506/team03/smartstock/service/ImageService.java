package com.uw.cs506.team03.smartstock.service;

import org.springframework.web.multipart.MultipartFile;

import com.uw.cs506.team03.smartstock.entity.Image;

/**
 * This class is the service for the image table
 */
public interface ImageService {
    /**
     * This method is used to save an image
     * @param file the image file
     * @return the saved image
     */
    Image saveImage(MultipartFile file);

    /**
     * This method is used to get an image by its id
     * @param id the id of the image
     * @return the image
     */
    Image getImage(Long id);
}