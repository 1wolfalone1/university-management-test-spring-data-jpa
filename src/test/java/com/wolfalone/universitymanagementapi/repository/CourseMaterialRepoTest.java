package com.wolfalone.universitymanagementapi.repository;

import com.wolfalone.universitymanagementapi.entity.Course;
import com.wolfalone.universitymanagementapi.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseMaterialRepoTest {

    @Autowired
    private CourseMaterialRepo courseMaterialRepo;


    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .credit(6)
                .title(".net")
                .build();
        CourseMaterial courseMaterial = CourseMaterial
                .builder()
                .course(course)
                .url("www.dailycode.com")
                .build();
        courseMaterialRepo.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterial =
                courseMaterialRepo.findAll();
        System.out.println(courseMaterial);
    }
}