package com.uw.cs506.team03.smartstock.controller;

import com.uw.cs506.team03.smartstock.entity.Image;
import com.uw.cs506.team03.smartstock.service.ImageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ImageControllerTest {

    @Mock
    private ImageService imageService;

    @InjectMocks
    private ImageController imageController;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(imageController).build();
    }

    @Test
    void uploadImage_ValidFile_ReturnsCreatedStatus() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "test.jpg", MediaType.IMAGE_JPEG_VALUE, "test image".getBytes());
        Image savedImage = new Image(file.getBytes());
        savedImage.setId(1L);

        when(imageService.saveImage(any(MockMultipartFile.class))).thenReturn(savedImage);

        mockMvc.perform(multipart("/images/upload").file(file))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    void uploadImage_InvalidFile_ReturnsInternalServerError() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "test.jpg", MediaType.IMAGE_JPEG_VALUE, "test image".getBytes());

        when(imageService.saveImage(any(MockMultipartFile.class))).thenThrow(new RuntimeException());

        mockMvc.perform(multipart("/images/upload").file(file))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void getImage_ValidId_ReturnsImageData() throws Exception {
        Long imageId = 1L;
        byte[] imageData = "test image".getBytes();
        Image image = new Image(imageData);
        image.setId(imageId);

        when(imageService.getImage(imageId)).thenReturn(image);

        mockMvc.perform(get("/images/{id}", imageId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_JPEG))
                .andExpect(content().bytes(imageData));
    }

    @Test
    void getImage_InvalidId_ReturnsNotFound() throws Exception {
        Long imageId = 1L;

        when(imageService.getImage(imageId)).thenThrow(new RuntimeException());

        mockMvc.perform(get("/images/{id}", imageId))
                .andExpect(status().isNotFound());
    }
}