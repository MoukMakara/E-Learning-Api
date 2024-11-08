package co.istad.elearningapi.service;

import co.istad.elearningapi.domain.Course;
import co.istad.elearningapi.dto.*;
import co.istad.elearningapi.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    @Override
    public CourseResponse createNewCourse(CourseCreateRequest courseCreateRequest) {
        // DTO Pattern CourseCreateRequest
        Course newCourse = Course.builder()
                .id(courseRepository.getLastCourseId() + 1)
                .title(courseCreateRequest.title())
                .description(courseCreateRequest.description())
                .price(courseCreateRequest.price())
                .status(true)
                .build();
        // add new course to the course repository
        courseRepository.getCourses().add(newCourse);

        // DTO Pattern CourseResponse
        return CourseResponse.builder()
                .id(newCourse.getId())
                .title(newCourse.getTitle())
                .description(newCourse.getDescription())
                .price(newCourse.getPrice())
                .build();
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        return courseRepository.getCourses().stream().map(course -> CourseResponse.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .price(course.getPrice())
                .instructor(InstructorResponse.builder()
                        .id(course.getInstructors().getId())
                        .name(course.getInstructors().getName())
                        .gender(course.getInstructors().getGender())
                        .biography(course.getInstructors().getBiography())
                        .build())
                .category(CategoryResponse.builder()
                        .id(course.getCategories().getLast().getId())
                        .name(course.getCategories().getLast().getName())
                        .build())
                .build()).toList();
    }

    @Override
    public CourseResponse updateCourse(Integer id, CourseUpdateRequest courseUpdateRequest) {
        Course updatedCourse = courseRepository.getCourses().stream()
                .filter(course -> course.getId().equals(id))
                .peek(course -> {
                    course.setTitle(courseUpdateRequest.title());
                    course.setDescription(courseUpdateRequest.description());
                    course.setPrice(courseUpdateRequest.price());
                })
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Course with id %d not found", id)));

        return CourseResponse.builder()
                .id(updatedCourse.getId())
                .title(updatedCourse.getTitle())
                .description(updatedCourse.getDescription())
                .price(updatedCourse.getPrice())
                .build();
    }

    @Override
    public void deleteCourse(Integer id) {
        Course deleteCourse = courseRepository.getCourses().stream().filter(course ->
                course.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Course with id %s not found", id)));

        courseRepository.getCourses().remove(deleteCourse);
    }

    @Override
    public CourseResponse getCourseById(Integer id) {
        return courseRepository.getCourses().stream()
                .filter(course -> course.getId().equals(id))
                .map(course -> CourseResponse.builder()
                        .id(course.getId())
                        .title(course.getTitle())
                        .description(course.getDescription())
                        .price(course.getPrice())
                        .instructor(InstructorResponse.builder()
                                .id(course.getInstructors().getId())
                                .name(course.getInstructors().getName())
                                .gender(course.getInstructors().getGender())
                                .biography(course.getInstructors().getBiography())
                                .build())
                        .category(CategoryResponse.builder()
                                .id(course.getCategories().getLast().getId())
                                .name(course.getCategories().getLast().getName())
                                .build())
                        .build())
                .findFirst()
                .orElseThrow(() -> new  ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Course not found with Id = %d", id)
                        ));
    }
}
