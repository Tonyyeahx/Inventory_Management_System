package com.uw.cs506.team03.smartstock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.uw.cs506.team03.smartstock.entity.Image;
import com.uw.cs506.team03.smartstock.service.ImageService;

/**
 * This class is the controller for the images
 */
@RestController
public class ImageController {
    
    @Autowired
    private ImageService imageService;

    /**
     * This is the default constructor for the ImageController class
     */
    public ImageController() {
    }

    /**
     * This method is used to upload an image
     * @param file the image file
     * @return the image that was uploaded
     */
    @PostMapping("images/upload")
    public ResponseEntity<Image> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Image savedImage = imageService.saveImage(file);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedImage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * This method is used to get an image
     * @param id the id of the image
     * @return the image with the specified id
     */
    @GetMapping("images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        try {
            Image image = imageService.getImage(id);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(image.getData());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}