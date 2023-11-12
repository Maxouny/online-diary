package com.example.onlinediary.controller;

import com.example.onlinediary.dto.GradesDTO;
import com.example.onlinediary.dto.StudentRequestDTO;
import com.example.onlinediary.entity.StudentEntity;
import com.example.onlinediary.exception.StudentNotFoundException;
import com.example.onlinediary.service.ClassesService;
import com.example.onlinediary.service.GradesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.onlinediary.service.StudentDataService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentDataService studentDataService;
    private final GradesService gradesService;
    private final ClassesService classesService;

    public StudentController(StudentDataService studentDataService, GradesService gradesService, ClassesService classesService) {
        this.studentDataService = studentDataService;
        this.gradesService = gradesService;
        this.classesService = classesService;
    }

    @GetMapping()
    public ResponseEntity getStudentByClass(@RequestParam(required = false, defaultValue = "0") int classesGroup) throws StudentNotFoundException {
        return ResponseEntity.ok(studentDataService.getByClassGroups(classesGroup));

    }

    @PostMapping("/update")
    public ResponseEntity<String> updateGrade(@RequestBody GradesDTO gradeDTO) throws StudentNotFoundException {
        gradesService.updateGrade(gradeDTO);
        return ResponseEntity.ok("Grade updated successfully.");
    }

    @PostMapping("/add")
    public ResponseEntity<StudentEntity> addStudentToClass(@RequestBody StudentRequestDTO studentRequest) {
        StudentEntity newStudent = new StudentEntity();
        newStudent.setFamily(studentRequest.getFamily());
        newStudent.setName(studentRequest.getName());
        newStudent.setAge(studentRequest.getAge());

        StudentEntity addedStudent = classesService.addStudentToClass(studentRequest.getClassesId(), newStudent);
        return ResponseEntity.ok(addedStudent);
    }
}
