package com.hoangphuccode.spring_boot_demo.repository;

import com.hoangphuccode.spring_boot_demo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
