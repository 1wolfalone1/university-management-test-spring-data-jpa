package com.wolfalone.universitymanagementapi.repository;

import com.wolfalone.universitymanagementapi.entity.Course;
import com.wolfalone.universitymanagementapi.entity.Student;
import com.wolfalone.universitymanagementapi.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


@SpringBootTest
class CourseRepoTest {

    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void printCourses() {
        List<Course> course =
                courseRepo.findAll();
        System.out.println("courses" + course);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Mana")
                .lastName("ka")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(4)
                .teacher(teacher)
                .build();
        courseRepo.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRepo =
                PageRequest.of(2, 3);
        Pageable secondPageWithTwoRepo =
                PageRequest.of(1, 2);
        List<Course> courses = courseRepo.findAll(firstPageWithThreeRepo).getContent();

        Long totalElement = courseRepo.findAll(firstPageWithThreeRepo).getTotalElements();
        int totalPages = courseRepo.findAll(firstPageWithThreeRepo).getTotalPages();
        System.out.println("courses + " + courses);
        System.out.println("Total element " + totalElement);
        System.out.println("Total page " + totalPages);

    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(0, 3, Sort.by("title"));
        Pageable sortByCredit =
                PageRequest.of(1, 3, Sort.by("credit").descending());

        Pageable sortByTitileAndCredit =
                PageRequest.of(0, 3, Sort.by("title")
                        .and(Sort.by("credit")));
        List<Course> courses = courseRepo.findAll(sortByTitileAndCredit).getContent();

        System.out.println(courses);


    }


    @Test
    public void printFindByTitleContaining() {
        Pageable firstPage = PageRequest.of(0, 2);
        List<Course> courses = courseRepo
                .findByTitleContaining("D", firstPage)
                .getContent();

        System.out.println(courses);
    }


    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Shing")
                .emailId("thiessn@gmail.commm")
                .build();
        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();
        course.addStudents(student);

        courseRepo.save(course);
    }
}
