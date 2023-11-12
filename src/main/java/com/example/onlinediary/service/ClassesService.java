package com.example.onlinediary.service;
import com.example.onlinediary.entity.ClassesEntity;
import com.example.onlinediary.entity.StudentEntity;
import com.example.onlinediary.exception.ClassesNotFoundException;
import com.example.onlinediary.exception.StudentNotFoundException;
import com.example.onlinediary.repository.ClassesRepo;
import com.example.onlinediary.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClassesService {

    @Autowired
    private ClassesRepo classesRepo;

    @Autowired
    private StudentRepo studentRepo;

    public StudentEntity addStudentToClass(Long classGroup, StudentEntity newStudent) throws ClassesNotFoundException {
        ClassesEntity classes = classesRepo.findByClassGroup(classGroup);

        newStudent.setClasses(classes);
        return studentRepo.save(newStudent);
    }


}
