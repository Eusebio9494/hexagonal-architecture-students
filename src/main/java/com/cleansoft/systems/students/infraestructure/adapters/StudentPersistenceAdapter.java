package com.cleansoft.systems.students.infraestructure.adapters;

import com.cleansoft.systems.students.application.ports.output.StudentPersistencePort;
import com.cleansoft.systems.students.domain.Model.StudentModel;

import java.util.List;
import java.util.Optional;

public class StudentPersistenceAdapter implements StudentPersistencePort {
    @Override
    public Optional<StudentModel> findStudentById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<StudentModel> findAll() {
        return List.of();
    }

    @Override
    public StudentModel saveStudent(StudentModel studentModel) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
