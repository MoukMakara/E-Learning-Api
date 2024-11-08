package co.istad.elearningapi.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    // many category have one course
    @ManyToOne
    private Course courses;
}
