package com.example.onlinediary.DTO;

import lombok.Data;

@Data
public class GradesDTO {
    private Long studentId;
    private String subject;
    private int newGrade;
}
