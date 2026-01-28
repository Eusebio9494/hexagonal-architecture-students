package com.cleansoft.systems.students.infraestructure.adapters;

import com.cleansoft.systems.students.application.ports.output.StudentPersistencePort;
import com.cleansoft.systems.students.domain.model.StudentModel;
import com.cleansoft.systems.students.infraestructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import com.cleansoft.systems.students.infraestructure.adapters.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort {

    private final StudentRepository repository;
    private final StudentPersistenceMapper mapper;

    @Override
    public Optional<StudentModel> findStudentById(Long id) {
        return repository.findById(id)
                .map(mapper::toStudentModel);
    }

    @Override
    public List<StudentModel> findAll() {
        return mapper.toListStudentModel(repository.findAll());
    }

    @Override
    public StudentModel saveStudent(StudentModel studentModel) {
        return mapper.toStudentModel(repository.save(mapper.toStudentEntity(studentModel)));
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);

    }
}
