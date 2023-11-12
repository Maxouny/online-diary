package com.example.onlinediary.service;

import com.example.onlinediary.DTO.StudentDataDTO;
import com.example.onlinediary.entity.StudentDataEntity;
import com.example.onlinediary.exception.StudentNotFoundException;
import com.example.onlinediary.repository.StudentDataRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class StudentDataSevice {

    @Autowired
    private StudentDataRepo studentDataRepo;


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
