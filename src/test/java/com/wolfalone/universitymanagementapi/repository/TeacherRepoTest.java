package com.wolfalone.universitymanagementapi.repository;

import com.wolfalone.universitymanagementapi.entity.Course;
import com.wolfalone.universitymanagementapi.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepoTest {

    @Autowired
    private TeacherRepo teacherRepo;


    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();
        Teacher teacher =
                Teacher.builder()
                        .firstName("Kha")
                        .lastName("Nguyen")
                        .courses(List.of(courseDBA, courseJava))
                        .build();

        teacherRepo.save(teacher);
    }

}