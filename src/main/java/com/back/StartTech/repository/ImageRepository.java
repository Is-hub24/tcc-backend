package com.back.StartTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.StartTech.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{
}