package com.back.StartTech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.StartTech.entity.Image;
import com.back.StartTech.repository.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Long saveImage(String fileName, String fileType, byte[] fileData) {
        Image image = new Image();
        image.setFileName(fileName);
        image.setFileType(fileType);
        image.setFileData(fileData);
        image = imageRepository.save(image);
        return image.getId();
    }

    public Image getImageById(Long id) {
        return imageRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Imagem não encontrada"));
    }
}