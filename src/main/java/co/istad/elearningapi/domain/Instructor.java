package co.istad.elearningapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String gender;
    private String biography;

    // one instructor have many course
    @OneToMany(mappedBy = "instructors")
    private List<Course> courses;
}
