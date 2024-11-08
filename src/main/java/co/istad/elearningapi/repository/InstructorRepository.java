package co.istad.elearningapi.repository;

import co.istad.elearningapi.domain.Instructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class InstructorRepository {
    private List<Instructor> instructors;

    private Integer getLastInstructorId(){
        return instructors.getLast().getId();
    }

    public InstructorRepository() {
        instructors = new ArrayList<>();
        instructors.add(Instructor.builder()
                        .id(1)
                        .name("Mouk Makara")
                        .gender("Male")
                        .biography("Java Instructor since 2024")
                .build());
        instructors.add(Instructor.builder()
                .id(1)
                .name("Chan Chhaya")
                .gender("Male")
                .biography("Spring Instructor since 2029")
                .build());
    }
}
