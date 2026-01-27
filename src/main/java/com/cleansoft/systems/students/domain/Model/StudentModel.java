package com.cleansoft.systems.students.domain.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StudentModel {

    private Long id;

    private String name;

    private String lastName;

    private Integer age;

    private String address;
}
