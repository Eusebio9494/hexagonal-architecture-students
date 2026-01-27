package com.cleansoft.systems.students.infraestructure.adapters.output.persistence.repository;

import com.cleansoft.systems.students.infraestructure.adapters.output.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    Optional<StudentEntity> findStudentById(Long id);

    List<StudentEntity> findAll();
}
