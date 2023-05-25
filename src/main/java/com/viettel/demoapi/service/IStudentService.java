package com.viettel.demoapi.service;

import com.viettel.demoapi.entity.Student;
import java.util.List;

public interface IStudentService {

    List<Student> getAll();
    Student getSingle(int studentId);
    Student create(Student student);
    Student update(Student student, int studentId);
    void delete(int studentId);
}
