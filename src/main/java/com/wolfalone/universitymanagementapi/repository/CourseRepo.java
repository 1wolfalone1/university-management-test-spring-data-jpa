package com.wolfalone.universitymanagementapi.repository;

import com.wolfalone.universitymanagementapi.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    Page<Course> findByTitleContaining(String title, Pageable pageable);
}
