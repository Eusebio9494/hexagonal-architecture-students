package com.cleansoft.systems.students.infraestructure.adapters.input.mapper;

import com.cleansoft.systems.students.domain.model.StudentModel;
import com.cleansoft.systems.students.infraestructure.adapters.input.model.request.StudentCreateRequest;
import com.cleansoft.systems.students.infraestructure.adapters.input.model.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Interface para mapear entre StudentCreateRequest, StudentModel y StudentResponse.
 *
 * @author Eusebio Olvera Chávez
 * @version 1.0.0
 * @since 27/01/2026
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentRestMapper {

//    @Mapping(target = "id", ignore = true)
    StudentModel toStudentModel(StudentCreateRequest request);

    StudentResponse toStudentResponse(StudentModel studentModel);

    List<StudentResponse> toStudentResponseList(List<StudentModel> studentModel);

}
