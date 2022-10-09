package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/student")

public class StudentController {

    @RequestMapping("/register")  //localhost:8080/student/register
    public  String register (){

        return "student/register";
    }
    @RequestMapping("/drop")       //localhost:8080/student/drop
    public  String drop (){

        return "student/drop";
    }


}
