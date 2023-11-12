package com.example.onlinediary.repository;

import com.example.onlinediary.entity.StudentDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface StudentDataRepo extends JpaRepository<StudentDataEntity, Long> {
    List<StudentDataEntity> findByClassesGroup(int classGroups);

}
