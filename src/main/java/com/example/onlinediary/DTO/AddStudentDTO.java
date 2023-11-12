package com.example.onlinediary.DTO;

import com.example.onlinediary.entity.StudentEntity;
import lombok.Data;

@Data
public class AddStudentDTO {
    private int classGroup;
    private StudentEntity newStudent;
}
