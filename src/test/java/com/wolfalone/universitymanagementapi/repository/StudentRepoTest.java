package com.wolfalone.universitymanagementapi.repository;

import com.wolfalone.universitymanagementapi.entity.Guardian;
import com.wolfalone.universitymanagementapi.entity.Student;
import lombok.With;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @BeforeEach
    void setUp() {
    }


//    @Test
//    public void saveStudent(){
//        Student student = Student.builder().emailId("thientry@gmail.com").firstName("Cao Nhat")
//                .lastName("Thien").guardianName("Ahihi")
//                .guardianEmail("nhatthienfpt@gmail.com")
//                .guardianMobile("09999999999").build();
//
//        studentRepo.save(student);
//    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("nhatthienfpt@gmail.com")
                .name("Promath")
                .mobile("09999999999")
                .build();
        Student student = Student.builder()
                .firstName("Cao Nhat")
                .lastName("Thien")
                .emailId("thien@gmail.com")
                .guardian(guardian)
                .build();
        studentRepo.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepo.findAll();

        System.out.println(studentList);
    }
}