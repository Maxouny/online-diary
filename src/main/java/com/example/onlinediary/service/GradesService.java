package com.example.onlinediary.service;

import com.example.onlinediary.DTO.GradesDTO;
import com.example.onlinediary.entity.GradesEntity;
import com.example.onlinediary.entity.StudentEntity;
import com.example.onlinediary.exception.StudentNotFoundException;
import com.example.onlinediary.repository.GradesRepo;
import com.example.onlinediary.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// GradeService.java
@Service
public class GradesService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private GradesRepo gradesRepo;

    public void updateGrade(GradesDTO gradeDTO) throws StudentNotFoundException {
        Optional<StudentEntity> optionalStudent = studentRepo.findById(gradeDTO.getStudentId());

        if (optionalStudent.isPresent()) {
            StudentEntity student = optionalStudent.get();
            GradesEntity grades = gradesRepo.findByStudent(student)
                    .orElseGet(() -> {
                        GradesEntity newGrades = new GradesEntity();
                        newGrades.setStudent(student);
                        return newGrades;
                    });

            switch (gradeDTO.getSubject().toLowerCase()) {
                case "physics":
                    grades.setPhysics(gradeDTO.getNewGrade());
                    break;
                case "mathematics":
                    grades.setMathematics(gradeDTO.getNewGrade());
                    break;
                case "rus":
                    grades.setRus(gradeDTO.getNewGrade());
                    break;
                case "literature":
                    grades.setLiterature(gradeDTO.getNewGrade());
                    break;
                case "geometry":
                    grades.setGeometry(gradeDTO.getNewGrade());
                    break;
                case "informatics":
                    grades.setInformatics(gradeDTO.getNewGrade());
                    break;
                default:
                    throw new IllegalArgumentException("Неверно указан предмет" + gradeDTO.getSubject());
            }
            grades.setAverageGrade(calculateAverageGrade(grades));
            gradesRepo.save(grades);
        } else {
            throw new StudentNotFoundException("Невереный studentId" + gradeDTO.getStudentId());
        }
    }
    private double calculateAverageGrade(GradesEntity grades) {
        return (grades.getPhysics() + grades.getMathematics() + grades.getLiterature() + grades.getGeometry() + grades.getInformatics()) / 5.0;
    }
}

