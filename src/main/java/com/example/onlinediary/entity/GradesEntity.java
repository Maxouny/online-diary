package com.example.onlinediary.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "grades")
public class GradesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private StudentEntity student;
}
