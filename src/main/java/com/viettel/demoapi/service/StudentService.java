package com.viettel.demoapi.service;

import com.viettel.demoapi.entity.Student;
import com.viettel.demoapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getSingle(int studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow();
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student, int studentId) {
        Student studentRepo = studentRepository.findById(studentId)
                .orElseThrow();
        if(Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())) {
            studentRepo.setName(student.getName());
        }
        if(Objects.nonNull(student.getEmail()) && !"".equalsIgnoreCase(student.getEmail())) {
            studentRepo.setEmail(student.getEmail());
        }
        if(student.getAge() != 0) {
            studentRepo.setAge(student.getAge());
        }
        if(student.getGpa() != 0) {
            studentRepo.setGpa(student.getGpa());
        }
        return studentRepository.save(studentRepo);
    }

    @Override
    public void delete(int studentId) {
        studentRepository.deleteById(studentId);
    }
}
