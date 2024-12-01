package com.back.StartTech.controller;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.StartTech.entity.Image;
import com.back.StartTech.entity.dtos.ImageRequest;
import com.back.StartTech.service.ImageService;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestBody ImageRequest request) {
        try {
            byte[] fileData = Base64.getDecoder().decode(request.getFileData());
            Long id = imageService.saveImage(request.getFileName(), request.getFileType(), fileData);
            return ResponseEntity.ok("{\"message\": \"Imagem salva com sucesso!\", \"id\": " + id + "}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\": \"Erro ao salvar a imagem.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        try {
            Image image = imageService.getImageById(id);
            return ResponseEntity.ok()
                    .header("Content-Type", image.getFileType())
                    .body(image.getFileData());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}