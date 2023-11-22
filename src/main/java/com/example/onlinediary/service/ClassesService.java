package com.example.onlinediary.service;
import com.example.onlinediary.entity.ClassesEntity;
import com.example.onlinediary.entity.StudentEntity;
import com.example.onlinediary.repository.ClassesRepo;
import com.example.onlinediary.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassesService {

    private final ClassesRepo classesRepo;
    private final StudentRepo studentRepo;

    public StudentEntity addStudentToClass(Long classGroup, StudentEntity newStudent){
        ClassesEntity classes = classesRepo.findByClassGroup(classGroup);

        newStudent.setClasses(classes);
        return studentRepo.save(newStudent);
    }
}
