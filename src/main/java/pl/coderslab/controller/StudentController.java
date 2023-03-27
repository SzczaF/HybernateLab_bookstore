package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("student", new Student());
        return "/student/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String form(Student student){
        return student.toString();
    }
    @ModelAttribute("countryItems")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("skillsItems")
    public Collection<String> skills() {
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("php");
        skills.add("python");
        skills.add("ruby");
        return skills;
    }

    @ModelAttribute("hobbyItems")
    public Collection<String> hobbies() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("sport");
        hobbies.add("programowanie");
        hobbies.add("f1");
        hobbies.add("badminton");
        return hobbies;
    }

}
