package com.example.onlinediary.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "student_data")
public class StudentDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "family")
    private String family;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "classes_group")
    private int classesGroup;

    @Column(name = "physics")
    private int physics;

    @Column(name = "mathematics")
    private int mathematics;

    @Column(name = "rus")
    private int rus;

    @Column(name = "literature")
    private int literature;

    @Column(name = "geometry")
    private int geometry;

    @Column(name = "informatics")
    private int informatics;

    @Column(name = "average_grade")
    private double averageGrade;
}


