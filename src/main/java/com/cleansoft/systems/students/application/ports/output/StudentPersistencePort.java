package com.cleansoft.systems.students.application.ports.output;

import com.cleansoft.systems.students.domain.model.StudentModel;

import java.util.List;
import java.util.Optional;

public interface StudentPersistencePort {

    Optional<StudentModel> findStudentById(Long id);

    List<StudentModel> findAll();

    StudentModel saveStudent(StudentModel studentModel);

    void deleteStudent(Long id);
}
