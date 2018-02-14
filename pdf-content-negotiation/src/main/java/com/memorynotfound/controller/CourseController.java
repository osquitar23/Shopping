package com.memorynotfound.controller;

import com.memorynotfound.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class CourseController {

    List<Course> documents = Arrays.asList(
            new Course(1, "Spring MVC PDF IText Example", new Date()),
            new Course(3, "Spring MVC PDF Lowagie Example", new Date())
    );

    @RequestMapping(method = RequestMethod.GET)
    public String getDocuments(Model model) {
        model.addAttribute("courses", documents);
        return "index";

    }
}
