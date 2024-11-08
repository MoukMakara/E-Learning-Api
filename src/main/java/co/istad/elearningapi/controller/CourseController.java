package co.istad.elearningapi.controller;

import co.istad.elearningapi.dto.CourseCreateRequest;
import co.istad.elearningapi.dto.CourseResponse;
import co.istad.elearningapi.dto.CourseUpdateRequest;
import co.istad.elearningapi.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CourseResponse createNewCourse(@Valid @RequestBody CourseCreateRequest courseCreateRequest){
        return courseService.createNewCourse(courseCreateRequest);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<CourseResponse> getAllCourses(){
        return courseService.getAllCourses();
    }

    @PutMapping("/{id}")
    CourseResponse updateCourse(@PathVariable Integer id, @RequestBody CourseUpdateRequest courseUpdateRequest){
        return courseService.updateCourse(id, courseUpdateRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    void deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
    }

    @GetMapping("/{id}")
    CourseResponse getCourseById(@PathVariable Integer id){
        return courseService.getCourseById(id);
    }
}
