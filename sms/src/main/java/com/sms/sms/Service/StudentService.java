package com.sms.sms.Service;

import com.sms.sms.Model.StudentModel;

import java.util.List;

public interface StudentService {
    List<StudentModel> getAllStudents();
    void saveStudents(StudentModel studentModel);
    StudentModel getStudentById(int id);
    void deleteStudentById(int id);
}
