package io.spring.api.courses.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.spring.api.courses.dao.CourseDao;
import io.spring.api.courses.entities.Course;


@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
		super();
	}
	
	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}
	
	@Override
	public Course getCourse(long courseId) {
		return courseDao.getById(courseId);
	}
	
	@Override
	public String addCourse(Course course) {
		courseDao.save(course);
		return course.getName();
	}
	
	@Override
	public Course updateCourse(Course course) {
		return courseDao.save(course);
	}
	
	@Override
	public Boolean deleteCourse(long id) {
		Course entity = courseDao.getOne(id);
		courseDao.delete(entity);
		return true;
	}
}
