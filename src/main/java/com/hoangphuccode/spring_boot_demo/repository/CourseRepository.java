package com.hoangphuccode.spring_boot_demo.repository;


import com.hoangphuccode.spring_boot_demo.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
