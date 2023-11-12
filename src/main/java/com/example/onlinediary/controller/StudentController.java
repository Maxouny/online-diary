package com.example.onlinediary.controller;

import com.example.onlinediary.DTO.AddStudentDTO;
import com.example.onlinediary.DTO.GradesDTO;
import com.example.onlinediary.DTO.StudentRequestDTO;
import com.example.onlinediary.entity.ClassesEntity;
import com.example.onlinediary.entity.StudentEntity;
import com.example.onlinediary.exception.ClassesNotFoundException;
import com.example.onlinediary.exception.StudentNotFoundException;
import com.example.onlinediary.repository.ClassesRepo;
import com.example.onlinediary.service.ClassesService;
import com.example.onlinediary.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.onlinediary.service.StudentDataSevice;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentDataSevice studentDataSevice;

    @Autowired
    private GradesService gradesService;

    @Autowired
    private ClassesService classesService;

    @GetMapping()
    public ResponseEntity getStudentByClass(@RequestParam(required = false, defaultValue = "0") int classesGroup) {
        try {
            return ResponseEntity.ok(studentDataSevice.getByClassGroups(classesGroup));
        } catch (StudentNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateGrade(@RequestBody GradesDTO gradeDTO) {
        try {
            gradesService.updateGrade(gradeDTO);
            return ResponseEntity.ok("Grade updated successfully.");
        } catch (StudentNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<StudentEntity> addStudentToClass(@RequestBody StudentRequestDTO studentRequest) {
        try {
            StudentEntity newStudent = new StudentEntity();
            newStudent.setFamily(studentRequest.getFamily());
            newStudent.setName(studentRequest.getName());
            newStudent.setAge(studentRequest.getAge());

            StudentEntity addedStudent = classesService.addStudentToClass(studentRequest.getClassesId(), newStudent);
            return ResponseEntity.ok(addedStudent);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
        }
    }

}
