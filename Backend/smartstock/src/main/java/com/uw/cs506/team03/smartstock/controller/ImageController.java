package com.uw.cs506.team03.smartstock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.uw.cs506.team03.smartstock.entity.Image;
import com.uw.cs506.team03.smartstock.service.ImageService;

@RestController
public class ImageController {
    
    @Autowired
    private ImageService imageService;

    @PostMapping("images/upload")
    public ResponseEntity<Image> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Image savedImage = imageService.saveImage(file);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedImage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

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