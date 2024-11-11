package com.hoangphuccode.spring_boot_demo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.hoangphuccode.spring_boot_demo.entity.CourseEntity;
import com.hoangphuccode.spring_boot_demo.entity.StudentEntity;
import com.hoangphuccode.spring_boot_demo.repository.CourseRepository;
import com.hoangphuccode.spring_boot_demo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class StudentCourseTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testAddData() {
        studentRepository.deleteById(4L);
        /*
        // Fetch existing Course entities from the database (if they already exist)
        CourseEntity course1 = courseRepository.findById(1L).orElseThrow(() -> new RuntimeException("Course not found"));
        CourseEntity course2 = courseRepository.findById(2L).orElseThrow(() -> new RuntimeException("Course not found"));

        // Create Student entities
        StudentEntity student1 = new StudentEntity();
        student1.setName("Jack");

        StudentEntity student2 = new StudentEntity();
        student2.setName("J97");

        // Associate the courses with the students
        student1.setCourseEntities(Arrays.asList(course1, course2));
        student2.setCourseEntities(Arrays.asList(course1, course2));

        // Save students, courses are already managed, so no detached entity issue
        studentRepository.save(student1);
        studentRepository.save(student2);
*/
    }
}
