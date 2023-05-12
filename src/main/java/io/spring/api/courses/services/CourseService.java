package io.spring.api.courses.services;

import java.util.List;

import io.spring.api.courses.entities.Course;


public interface CourseService {
	
	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public String addCourse(Course course);
	public Course updateCourse(Course course);
	public Boolean deleteCourse(long id);
	
}
