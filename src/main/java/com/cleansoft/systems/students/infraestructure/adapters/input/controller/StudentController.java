package com.cleansoft.systems.students.infraestructure.adapters.input.controller;

import com.cleansoft.systems.students.application.ports.input.StudentServicePort;
import com.cleansoft.systems.students.application.ports.output.PdfTemplatePort;
import com.cleansoft.systems.students.infraestructure.adapters.input.mapper.StudentRestMapper;
import com.cleansoft.systems.students.infraestructure.adapters.input.model.request.StudentCreateRequest;
import com.cleansoft.systems.students.infraestructure.adapters.input.model.response.PdfResponse;
import com.cleansoft.systems.students.infraestructure.adapters.input.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * StudentController
 *
 * @author Eusebio Olvera Chávez
 * @version 1.0.0
 * @since 27/01/2026
 */
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServicePort studentServicePort;
    private final StudentRestMapper studentRestMapper;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentRestMapper.toStudentResponseList(studentServicePort.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentRestMapper.toStudentResponse(studentServicePort.findStudentById(id)));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentCreateRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentRestMapper.toStudentResponse(studentServicePort.saveStudent(studentRestMapper.toStudentModel(request))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(@Valid @RequestBody StudentCreateRequest request, @PathVariable("id") Long id){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(studentRestMapper.toStudentResponse(studentServicePort.updateStudent(studentRestMapper.toStudentModel(request), id)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        studentServicePort.deleteStudentById(id);
    }
}
