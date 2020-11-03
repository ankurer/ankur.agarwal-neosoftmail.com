package com.springrest.service;

import java.util.List;

import com.springrest.entity.CourseDTO;

public interface CourseServiceInt {
	
	public List<CourseDTO> getCourse();
	
	public CourseDTO getSingleCourse(Long courseId);
	
	public CourseDTO addCourse(CourseDTO course);
	
	public CourseDTO updateCourse(CourseDTO course);
	
	public void deleteCourse(Long courseId);

}
