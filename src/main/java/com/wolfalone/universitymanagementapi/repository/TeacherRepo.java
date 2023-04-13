package com.wolfalone.universitymanagementapi.repository;


import com.wolfalone.universitymanagementapi.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

}
