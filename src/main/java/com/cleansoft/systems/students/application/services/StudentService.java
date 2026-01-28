package com.cleansoft.systems.students.application.services;

import com.cleansoft.systems.students.application.ports.input.StudentServicePort;
import com.cleansoft.systems.students.application.ports.output.StudentPersistencePort;
import com.cleansoft.systems.students.domain.model.StudentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService implements StudentServicePort {

    private final StudentPersistencePort studentPersistencePort;

    @Override
    public StudentModel findStudentById(Long id) {
        return studentPersistencePort.findStudentById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<StudentModel> findAll() {
        return studentPersistencePort.findAll();
    }

    @Override
    public StudentModel saveStudent(StudentModel studentModel) {
        return studentPersistencePort.saveStudent(studentModel);
    }

    @Override
    public StudentModel updateStudent(StudentModel studentModel, Long id) {
        return studentPersistencePort.findStudentById(id)
                .map(savedStudent -> {
                    savedStudent.setAge(studentModel.getAge());
                    savedStudent.setAddress(studentModel.getAddress());
                    return studentPersistencePort.saveStudent(savedStudent);
                }
                ).orElseThrow(RuntimeException::new);

    }

    @Override
    public void deleteStudentById(Long id) {
        if (studentPersistencePort.findStudentById(id).isEmpty()) {
            throw new RuntimeException("No se encontró estudiante");
        }
        studentPersistencePort.deleteStudent(id);

    }
}
