package com.cleansoft.systems.students.util;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

    STUDENT_NOT_FOUND("ERR_STUDENT_001", "No se encontró estudiante"),
    STUDENTS_NOT_FOUND("ERR_STUDENT_001", "No se encontraron estudiantes"),
    STUDENT_ALREADY_EXISTS("ERR_STUDENT_002", "Student already exists"),
    INVALID_STUDENT_DATA("ERR_STUDENT_003", "Invalid student data"),
    INTERNAL_SERVER_ERROR("ERR_GEN_004", "Internal server error");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
