package com.cleansoft.systems.students.application.ports.input;

import com.cleansoft.systems.students.domain.model.StudentModel;

import java.util.List;

public interface StudentServicePort {

    StudentModel findStudentById(Long id);

    List<StudentModel> findAll();

    StudentModel saveStudent(StudentModel studentModel);

    StudentModel updateStudent(StudentModel studentModel, Long id);

    void deleteStudentById(Long id);
}
