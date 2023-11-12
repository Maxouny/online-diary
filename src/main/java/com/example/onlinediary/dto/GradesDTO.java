package com.example.onlinediary.dto;

import lombok.Data;

@Data
public class GradesDTO {
    private Long studentId;
    private Subject subject;
    private int newGrade;
}
