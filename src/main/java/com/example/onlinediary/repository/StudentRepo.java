package com.example.onlinediary.repository;

import com.example.onlinediary.entity.GradesEntity;
import com.example.onlinediary.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findById(Long id);

}
