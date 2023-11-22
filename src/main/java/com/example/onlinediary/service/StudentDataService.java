package com.example.onlinediary.service;

import com.example.onlinediary.dto.StudentDataDTO;
import com.example.onlinediary.entity.StudentDataEntity;
import com.example.onlinediary.repository.StudentDataRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentDataService {

    private final StudentDataRepo studentDataRepo;
    public List<StudentDataDTO> getByClassGroups(int classesGroup) {
        List<StudentDataEntity> studentData = studentDataRepo.findByClassesGroup(classesGroup);

        if (studentData.isEmpty()) {
            return Collections.emptyList();
        }
        return mapToDTOs(studentData);
    }
    private List<StudentDataDTO> mapToDTOs(List<StudentDataEntity> studentData) {
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
    }
}

