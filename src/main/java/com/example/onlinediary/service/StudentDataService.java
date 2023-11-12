package com.example.onlinediary.service;

import com.example.onlinediary.dto.StudentDataDTO;
import com.example.onlinediary.entity.StudentDataEntity;
import com.example.onlinediary.exception.StudentNotFoundException;
import com.example.onlinediary.repository.StudentDataRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class StudentDataService {

    private final StudentDataRepo studentDataRepo;

    public StudentDataService(StudentDataRepo studentDataRepo) {
        this.studentDataRepo = studentDataRepo;
    }


    public List<StudentDataDTO> getByClassGroups(int classesGroup) throws StudentNotFoundException {
        List<StudentDataEntity> studentData = studentDataRepo.findByClassesGroup(classesGroup);

        if (!studentData.isEmpty()) {
            List<StudentDataDTO> listStudentDTO = new ArrayList<>();
            for (StudentDataEntity student : studentData) {
                StudentDataDTO studentDTO = new StudentDataDTO();
                studentDTO.setFamily(student.getFamily());
                studentDTO.setName(student.getName());
                studentDTO.setAge(student.getAge());
                studentDTO.setClassesGroup(student.getClassesGroup());
                studentDTO.setAverageGrade(student.getAverageGrade());
                listStudentDTO.add(studentDTO);
            }
            return listStudentDTO;
        } else {
            throw new StudentNotFoundException("Группа не найдена " + classesGroup);
        }
    }
}
