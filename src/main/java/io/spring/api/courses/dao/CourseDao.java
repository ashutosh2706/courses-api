package io.spring.api.courses.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.spring.api.courses.entities.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Long> {
	
}
