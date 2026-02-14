package com.cleansoft.systems.students.infraestructure.adapters.output.persistence.mapper;

import com.cleansoft.systems.students.domain.model.StudentModel;
import com.cleansoft.systems.students.infraestructure.adapters.output.persistence.entity.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Interface para mapear entre StudentEntity y StudentModel.
 *
 * @author Eusebio Olvera Chávez
 * @version 1.0.0
 * @since 27/01/2026
 */
@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {

    StudentEntity toStudentEntity(StudentModel studentModel);

    StudentModel toStudentModel(StudentEntity studentEntity);

    List<StudentModel> toListStudentModel(List<StudentEntity> entityList);
}
