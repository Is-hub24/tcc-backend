package com.back.StartTech.entity.dtos;

public class ImageResponse {
    private Long id;
    private String fileName;
    private String fileType;
    private String fileData; // Base64

    public ImageResponse(Long id, String fileName, String fileType, String fileData) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileData() {
        return fileData;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }
}