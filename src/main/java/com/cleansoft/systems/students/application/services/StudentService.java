package com.cleansoft.systems.students.application.services;

import com.cleansoft.systems.students.application.ports.input.StudentServicePort;
import com.cleansoft.systems.students.application.ports.output.StudentPersistencePort;
import com.cleansoft.systems.students.domain.exception.StudentException;
import com.cleansoft.systems.students.domain.model.StudentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cleansoft.systems.students.util.ErrorCatalog.STUDENTS_NOT_FOUND;
import static com.cleansoft.systems.students.util.ErrorCatalog.STUDENT_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class StudentService implements StudentServicePort {

    private final StudentPersistencePort studentPersistencePort;

    @Override
    public StudentModel findStudentById(Long id) {
        return studentPersistencePort.findStudentById(id).orElseThrow(() -> new StudentException(STUDENT_NOT_FOUND.getMessage()));
    }

    @Override
    public List<StudentModel> findAll() {
        List<StudentModel> studentModelList = studentPersistencePort.findAll();
        if (studentModelList.isEmpty()) {
            throw new StudentException(STUDENTS_NOT_FOUND.getMessage());
        }
        return studentModelList;
    }

    @Override
    public StudentModel saveStudent(StudentModel studentModel) {
        return studentPersistencePort.saveStudent(studentModel);
    }

    @Override
    public StudentModel updateStudent(StudentModel studentModel, Long id) {
        return studentPersistencePort.findStudentById(id)
                .map(savedStudent -> {
                         savedStudent.setFirstName(studentModel.getFirstName());
                         savedStudent.setLastName(studentModel.getLastName());
                         savedStudent.setAge(studentModel.getAge());
                         savedStudent.setAddress(studentModel.getAddress());
                         return studentPersistencePort.saveStudent(savedStudent);
                     }
                ).orElseThrow(() -> new StudentException(STUDENT_NOT_FOUND.getMessage()));

    }

    @Override
    public void deleteStudentById(Long id) {
        if (studentPersistencePort.findStudentById(id).isEmpty()) {
            throw new RuntimeException("No se encontró estudiante");
        }
        studentPersistencePort.deleteStudent(id);

    }
}
