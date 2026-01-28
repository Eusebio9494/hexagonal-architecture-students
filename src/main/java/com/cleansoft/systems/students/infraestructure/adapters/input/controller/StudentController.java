package com.cleansoft.systems.students.infraestructure.adapters.input.controller;

import com.cleansoft.systems.students.application.ports.input.StudentServicePort;
import com.cleansoft.systems.students.infraestructure.adapters.input.mapper.StudentRestMapper;
import com.cleansoft.systems.students.infraestructure.adapters.input.model.request.StudentCreateRequest;
import com.cleansoft.systems.students.infraestructure.adapters.input.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServicePort studentServicePort;
    private final StudentRestMapper studentRestMapper;

    @GetMapping
    public List<StudentResponse> findAll() {
        return studentRestMapper.toStudentResponseList(studentServicePort.findAll());
    }

    @GetMapping("/{id}")
    public StudentResponse findById(@PathVariable("id") Long id) {
        return studentRestMapper.toStudentResponse(studentServicePort.findStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentCreateRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentRestMapper.toStudentResponse(studentServicePort.saveStudent(studentRestMapper.toStudentModel(request))));
    }

    @PutMapping
    public ResponseEntity<StudentResponse> update(@Valid @RequestBody StudentCreateRequest request, @PathVariable("id") Long id){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(studentRestMapper.toStudentResponse(studentServicePort.updateStudent(studentRestMapper.toStudentModel(request), id)));
    }

    @DeleteMapping
    public void delete(@PathVariable("id") Long id){
        studentServicePort.deleteStudentById(id);
    }
}
