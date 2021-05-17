package com.sms.sms.Controller;

import com.sms.sms.Model.StudentModel;
import com.sms.sms.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    //display studentList
    @GetMapping("/")
    public String StudentList(Model model){
        model.addAttribute("Students",studentService.getAllStudents());
        return "index";
    }
    @GetMapping("/newStudentForm")
    public String newStudentForm(Model model){
        StudentModel studentModel=new StudentModel();
        model.addAttribute("student",studentModel);
        return "new_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") StudentModel studentModel){
        studentService.saveStudents(studentModel);
        return "redirect:/";
    }

    @GetMapping("/updateForm/{id}")
    public String updateForm(@PathVariable(value="id") int id,Model model){
        StudentModel studentModel=studentService.getStudentById(id);
        model.addAttribute("student",studentModel);
        return "update_student";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable (value="id") int id){
        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }
}
