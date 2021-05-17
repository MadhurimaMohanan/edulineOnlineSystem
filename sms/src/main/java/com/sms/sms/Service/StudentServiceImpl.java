package com.sms.sms.Service;

import com.sms.sms.Model.StudentModel;
import com.sms.sms.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<StudentModel> getAllStudents() {
         return studentRepository.findAll();
    }

    @Override
    public void saveStudents(StudentModel studentModel) {
        this.studentRepository.save(studentModel);
    }

    @Override
    public StudentModel getStudentById(int id) {
        Optional<StudentModel> optional=studentRepository.findById(id);
        StudentModel studentModel=null;
        if(optional.isPresent())
        {
            studentModel=optional.get();
        }
        else
        {
            throw new RuntimeException("Student Not Found for id ::" + id);
        }
        return studentModel;
    }

    @Override
    public void deleteStudentById(int id) {
        this.studentRepository.deleteById(id);
    }
}
