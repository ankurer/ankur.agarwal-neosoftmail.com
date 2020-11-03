package com.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.CourseDAO;
import com.springrest.entity.CourseDTO;

@Service
public class CourseServiceImpl implements CourseServiceInt{

	
	//private List<CourseDTO> list=null;
	
	@Autowired
	private CourseDAO courseDAO;
	
	public CourseServiceImpl() {
	
		/*
		 * list = new ArrayList<>(); list.add(new
		 * CourseDTO(101,"Java","This is java course")); list.add(new
		 * CourseDTO(102,"hibernate","This is hibernate course"));
		 */
	
	 }
	
	@Override
	public List<CourseDTO> getCourse() {
		
		//return list;
		
		return courseDAO.findAll();
		
	}

	@Override
	public CourseDTO getSingleCourse(Long courseId) {
		
		//CourseDTO c=null;
		
//		for(CourseDTO course:list) {
//			
//			if(course.getId()==courseId) {
//				c= course;
//				break;
//			}
//		}
		
		
		
		return courseDAO.getOne(courseId);
	}

	@Override
	public CourseDTO addCourse(CourseDTO course) {
		// TODO Auto-generated method stub
		 //list.add(course);
		 
		  courseDAO.save(course);
		return course;
	}

	@Override
	public CourseDTO updateCourse(CourseDTO course) {
		
//		list.forEach(e->{
//			
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		
	     courseDAO.save(course);
		return course;
		
	}

	@Override
	public void deleteCourse(Long courseId) {
		
//		for(CourseDTO course:list) {
//		
//			if(course.getId()==courseId) {
//				list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
//				
//			}
//		}
		
		 CourseDTO entity=courseDAO.getOne(courseId);
		 courseDAO.delete(entity);
			
	}

	

	

	
	
}
