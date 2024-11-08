package co.istad.elearningapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Builder

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id auto increment
    private Integer id;
    private String title;
    private String description;
    private BigDecimal price;
    private Boolean status;

    // many course have one instructor
    @ManyToOne
    private Instructor instructors;

    // one course have many category
    @OneToMany(mappedBy = "courses")
    private List<Category> categories;
}
