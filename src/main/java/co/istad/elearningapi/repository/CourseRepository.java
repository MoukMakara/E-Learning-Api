package co.istad.elearningapi.repository;

import co.istad.elearningapi.domain.Category;
import co.istad.elearningapi.domain.Course;
import co.istad.elearningapi.domain.Instructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class CourseRepository {
    private List<Course> courses;
    private final InstructorRepository instructorRepository;
    private final CategoryRepository CategoryRepository;

    public Integer getLastCourseId(){
        return courses.getLast().getId();
    }

    public CourseRepository(InstructorRepository instructorRepository, CategoryRepository categoryRepository) {
        this.instructorRepository = instructorRepository;
        this.CategoryRepository = categoryRepository;
        courses = new ArrayList<>();
        courses.add(Course.builder()
                        .id(1)
                        .title("Spring Framework")
                        .description("Spring Framework GURU")
                        .price(BigDecimal.valueOf(300.00))
                        .status(true)
                            .instructors(instructorRepository.getInstructors().get(0))
                        .categories(List.of(categoryRepository.getCategories().get(0)))
                .build());
        courses.add(Course.builder()
                .id(2)
                .title("Java Programming")
                .description("Java Programming Basic")
                .price(BigDecimal.valueOf(200.00))
                .status(true)
                        .instructors(instructorRepository.getInstructors().get(1))
                        .categories(List.of(categoryRepository.getCategories().get(1)))
                .build());
        courses.add(Course.builder()
                .id(3)
                .title("C++ Programming")
                .description("Object Oriented Programming")
                .price(BigDecimal.valueOf(100.00))
                .status(true)
                .instructors(instructorRepository.getInstructors().get(0))
                .categories(List.of(categoryRepository.getCategories().get(0)))
                .build());
    }
}
