package co.istad.elearningapi.service;

import co.istad.elearningapi.dto.CourseCreateRequest;
import co.istad.elearningapi.dto.CourseResponse;
import co.istad.elearningapi.dto.CourseUpdateRequest;

import java.util.List;

public interface CourseService {
    CourseResponse createNewCourse(CourseCreateRequest courseCreateRequest);
    List<CourseResponse> getAllCourses();
    CourseResponse updateCourse(Integer id, CourseUpdateRequest courseUpdateRequest);
    void deleteCourse(Integer id);
    CourseResponse getCourseById(Integer id);
}
