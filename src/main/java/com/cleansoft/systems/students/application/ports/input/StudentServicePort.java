package com.cleansoft.systems.students.application.ports.input;

import com.cleansoft.systems.students.domain.Model.StudentModel;

import java.util.List;
import java.util.Optional;

public interface StudentServicePort {

    StudentModel findStudentById(Long id);

    List<StudentModel> findAll();

    StudentModel saveStudent(StudentModel studentModel);

    StudentModel updateStudent(StudentModel studentModel);

    void deleteStudent(Long id);
}
