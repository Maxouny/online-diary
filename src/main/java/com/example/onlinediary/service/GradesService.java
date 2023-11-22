package com.example.onlinediary.service;

import com.example.onlinediary.dto.GradesDTO;
import com.example.onlinediary.dto.Subject;
import com.example.onlinediary.entity.GradesEntity;
import com.example.onlinediary.entity.StudentEntity;
import com.example.onlinediary.exception.StudentNotFoundException;
import com.example.onlinediary.repository.GradesRepo;
import com.example.onlinediary.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradesService {

    private final StudentRepo studentRepo;
    private final GradesRepo gradesRepo;

    public void updateGrade(GradesDTO gradeDTO) throws StudentNotFoundException {
        Optional<StudentEntity> optionalStudent = studentRepo.findById(gradeDTO.getStudentId());

        if (optionalStudent.isEmpty()) {
            throw new StudentNotFoundException("Invalid studentId: " + gradeDTO.getStudentId());
        }
        StudentEntity student = optionalStudent.get();
        GradesEntity grades = gradesRepo.findByStudent(student)
                .orElseGet(() -> {
                    GradesEntity newGrades = new GradesEntity();
                    newGrades.setStudent(student);
                    return newGrades;
                });

        updateGradeForSubject(gradeDTO.getSubject(), gradeDTO.getNewGrade(), grades);
        grades.setAverageGrade(calculateAverageGrade(grades));
        gradesRepo.save(grades);
    }
    private void updateGradeForSubject(Subject subject, int newGrade, GradesEntity grades) {
        switch (subject) {
            case PHYSICS -> grades.setPhysics(newGrade);
            case MATHEMATICS -> grades.setMathematics(newGrade);
            case RUS -> grades.setRus(newGrade);
            case LITERATURE -> grades.setLiterature(newGrade);
            case GEOMETRY -> grades.setGeometry(newGrade);
            case INFORMATICS -> grades.setInformatics(newGrade);
            default -> throw new IllegalArgumentException("Invalid subject: " + subject);
        }
    }
    private double calculateAverageGrade(GradesEntity grades) {
        return (grades.getPhysics() + grades.getMathematics() + grades.getLiterature() + grades.getGeometry() + grades.getInformatics()) / 5.0;
    }
}




