package com.cleansoft.systems.students.application.ports.output;

import com.cleansoft.systems.students.domain.model.StudentModel;

import java.util.List;
import java.util.Optional;


/**
 * Puertos de persistencia para la entidad Student.
 *
 * @author Eusebio Olvera Chávez
 * @version 1.0.0
 * @since 27/01/2026
 */
public interface StudentPersistencePort {

    Optional<StudentModel> findStudentById(Long id);

    List<StudentModel> findAll();

    StudentModel saveStudent(StudentModel studentModel);

    void deleteStudent(Long id);
}
