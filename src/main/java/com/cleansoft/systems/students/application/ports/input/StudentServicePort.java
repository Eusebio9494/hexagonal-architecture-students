package com.cleansoft.systems.students.application.ports.input;

import com.cleansoft.systems.students.domain.model.StudentModel;

import java.util.List;

/**
 * Puertos de entrada para la especificación de casos de uso relacionados con estudiantes.
 * @author Eusebio Olvera Chávez
 * @version 1.0.0
 * @since 27/01/2026
 */
public interface StudentServicePort {

    StudentModel findStudentById(Long id);

    List<StudentModel> findAll();

    StudentModel saveStudent(StudentModel studentModel);

    StudentModel updateStudent(StudentModel studentModel, Long id);

    void deleteStudentById(Long id);
}
