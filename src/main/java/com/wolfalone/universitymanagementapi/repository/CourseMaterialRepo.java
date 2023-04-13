package com.wolfalone.universitymanagementapi.repository;


import com.wolfalone.universitymanagementapi.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseMaterialRepo extends JpaRepository<CourseMaterial, Long> {
}
