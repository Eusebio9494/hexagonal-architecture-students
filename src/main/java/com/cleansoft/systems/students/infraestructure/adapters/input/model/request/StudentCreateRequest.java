package com.cleansoft.systems.students.infraestructure.adapters.input.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {

    @NotBlank(message = "Field firstName cannot be empty or null")
    private String firstName;
    @NotBlank(message = "Field firstName cannot be empty or null")
    private String lastName;
    @NotNull(message = "Field age cannot be null")
    private Integer age;
    @NotBlank(message = "Field address cannot be empty or null")
    private String address;
}
