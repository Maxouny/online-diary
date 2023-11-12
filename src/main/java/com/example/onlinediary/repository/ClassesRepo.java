package com.example.onlinediary.repository;

import com.example.onlinediary.entity.ClassesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassesRepo extends JpaRepository<ClassesEntity, Long> {
    ClassesEntity findByClassGroup(Long classGroup);
}
