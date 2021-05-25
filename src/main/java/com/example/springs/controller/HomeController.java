package com.example.springs.controller;


import com.example.springs.entities.Course;
import com.example.springs.request.CourseRequest;
import com.example.springs.services.CourseService;
import com.example.springs.services.iCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    CourseService courseService;

    @PostMapping("addcourse")
    public Course addCourse(@RequestBody CourseRequest courseRequest) {
        return courseService.addCourseWithContents(courseRequest);
    }
    @PutMapping("/action/update")
    public ResponseEntity<?> updateCourse(@RequestBody Course course) {
        return ResponseEntity.ok(iCourse.update(course));
    }

    // DELETE
    @DeleteMapping("/action/delete/{id}")
    public void deleteBookById(@PathVariable("id") int id) {
        iCourse.deleteCourseById(id);
    }



}
