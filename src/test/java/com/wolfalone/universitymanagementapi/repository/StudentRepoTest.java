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

    @Test
    public void printStudetnByFirstName() {
        List<Student> list = studentRepo.findByFirstNameContaining("Cao");
        list.stream().forEach(e -> {
            System.out.println(e.toString());
        });
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepo.findByGuardianName("Ahihi");
        System.out.println(students);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student =
                studentRepo.getStudentByEmailAddress("thien@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetFirstNameOfStudentByEmailAddress(){
        String studentName = studentRepo.getStudentFirstNameByEmailAddress("thien@gmail.com");
        System.out.println(studentName);

    }

    @Test
    public void printGetStudentByEmailUsingNativeQuery(){
        Student student = studentRepo.getStudentByEmailAddressNative("thien@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepo
                .getStudentByEmailAddressNativeNameParam("thien@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        int count = studentRepo.updateStudentNameByEmailId("ThienHihi", "thien@gmail.com");
        System.out.println(count);
    }
}
