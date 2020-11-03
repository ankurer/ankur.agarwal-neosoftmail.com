package com.springrest.controller;

import java.util.List;

import javax.xml.bind.ParseConversionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entity.CourseDTO;
import com.springrest.service.CourseServiceInt;

@RestController
public class CourseCTL {

	@Autowired
	private CourseServiceInt courseService;
	
	@GetMapping("/home")
	public String home() {
		
		return "this is test";
	}
	
	
	@GetMapping("/courses")
	public List<CourseDTO> getAllCourses(){
		
		
		return this.courseService.getCourse();
	}
	
	
	// Error occured
	
	@GetMapping("/course/{id}")
	public CourseDTO getSingleCourse(@PathVariable String id) {
		
		
		return courseService.getSingleCourse(Long.parseLong(id));
	}
	
	
	@PostMapping("/add")
	public CourseDTO add(@RequestBody CourseDTO course) {
		
		return this.courseService.addCourse(course);
	}
	
	
	@PutMapping("/updateCourses")
	public CourseDTO update(@RequestBody CourseDTO course) {
		
		return this.courseService.updateCourse(course);
	}
	
	
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable String id){
		
		try {
		
			this.courseService.deleteCourse(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
		    System.out.println("catch executed");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

}