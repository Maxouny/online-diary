package com.example.onlinediary.repository;

import com.example.onlinediary.entity.StudentDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDataRepo extends JpaRepository<StudentDataEntity, Long> {
    List<StudentDataEntity> findByClassesGroup(int classGroups);

}
