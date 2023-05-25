package com.viettel.demoapi.controller;

import com.viettel.demoapi.entity.Student;
import com.viettel.demoapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getSingleStudent(@PathVariable("id") int studentId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.getSingle(studentId));
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.create(student));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int studentId, @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.update(student, studentId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        studentService.delete(studentId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Delete student successfully!!!");
    }
}
