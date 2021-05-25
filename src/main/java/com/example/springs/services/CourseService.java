package com.example.springs.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import com.example.springs.entities.Course;
import com.example.springs.entities.CourseContents;
import com.example.springs.repositories.CourseContentRepository;
import com.example.springs.repositories.CourseRepository;
import com.example.springs.request.CourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements iCourse {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseContentRepository coursecontentRepo;

    public CourseService() {
    }

    public Course addCourseWithContents(CourseRequest courseRequest) {
        Course course = new Course();
        course.setId(courseRequest.id);
        course.setCoursename(courseRequest.coursename);
        course.setCoursecontents(courseRequest.coursecontents
                .stream()
                .map(coursecontent -> {
                    CourseContents ccontents = coursecontent;
                    if (ccontents.getId() > 0) {
                        ccontents = coursecontentRepo.findById(ccontents.getId());
                    }
                    ccontents.addCourse(course);
                    return ccontents;
                })
                .collect(Collectors.toSet()));

        return courseRepository.save(course);
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    public Course update(Course course) {
        return courseRepository.saveAndFlush(course);
    }

    public void deleteCourseById(int id) {
        courseRepository.deleteById(id);
    }


}

