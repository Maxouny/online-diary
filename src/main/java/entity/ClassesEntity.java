package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "classes")
public class ClassesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "class_group")
    private int classGroup;

    @ManyToOne
    @JoinColumn(name="curricula_id", nullable=false)
    private CurriculaEntity curricula;

}
