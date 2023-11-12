package com.example.onlinediary.dto;

import com.example.onlinediary.entity.StudentEntity;
import lombok.Data;

@Data
public class AddStudentDTO {
    private int classGroup;
    private StudentEntity newStudent;
}
