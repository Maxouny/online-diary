package com.example.onlinediary.DTO;

import lombok.Data;

@Data
public class StudentRequestDTO {
    private Long classesId;
    private String family;
    private String name;
    private int age;
}
