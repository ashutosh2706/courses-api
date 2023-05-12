package io.spring.api.courses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.spring.api.courses.entities.Course;
import io.spring.api.courses.services.CourseService;

@RestController
public class AppController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/")
	public String homePage() {
		return "Welcome to Courses API.\n";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public String addCourse(@RequestBody Course course) {
		return "Course: " + this.courseService.addCourse(course) + " has been added";
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {	
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String id) {
		
		Boolean status = this.courseService.deleteCourse(Long.parseLong(id));
		if(status) return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
