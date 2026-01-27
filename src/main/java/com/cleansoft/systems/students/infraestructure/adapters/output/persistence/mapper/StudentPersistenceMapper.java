package com.cleansoft.systems.students.infraestructure.adapters.output.persistence.mapper;

import com.cleansoft.systems.students.domain.Model.StudentModel;
import com.cleansoft.systems.students.infraestructure.adapters.output.persistence.entity.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {

    StudentEntity toStudentEntity(StudentModel studentModel);

    StudentModel toStudentModel(StudentEntity studentEntity);

    List<StudentModel> toListStudentModel(List<StudentEntity> entityList);
}
