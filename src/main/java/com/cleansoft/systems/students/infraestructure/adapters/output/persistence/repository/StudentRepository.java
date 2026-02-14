package com.cleansoft.systems.students.infraestructure.adapters.output.persistence.repository;

import com.cleansoft.systems.students.infraestructure.adapters.output.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio JPA para la entidad Student.
 *
 * @author Eusebio Olvera Chávez
 * @version 1.0.0
 * @since 27/01/2026
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    Optional<StudentEntity> findById(Long id);

    List<StudentEntity> findAll();
}
