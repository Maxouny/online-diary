package com.example.onlinediary.repository;

import com.example.onlinediary.entity.GradesEntity;
import com.example.onlinediary.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GradesRepo extends JpaRepository<GradesEntity, Long> {

    List<GradesEntity> findByStudentId(Long studentId);
    Optional<GradesEntity> findByStudent(StudentEntity student);
//    GradesEntity findByAverageGrade(double average);
//    GradesEntity findByPhysics(int physics);
//    GradesEntity findByMathematics(int mathematics);
//    GradesEntity findByRus(int rus);
//    GradesEntity findByLiterature(int literature);
//    GradesEntity findByGeometry(int geometry);
//    GradesEntity findByInformatics(int informatics);

}
