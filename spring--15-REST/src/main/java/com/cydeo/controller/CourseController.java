package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.stereotype.Controller;   //@Controller + @ResponseBody So no need
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@Controller + @ResponseBody
@RequestMapping ("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){

        return courseService.getCourses();
    }

   

}
