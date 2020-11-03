package com.springrest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "course")
@SequenceGenerator(name="seq", initialValue=1)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CourseDTO {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(generator = "demo")
	//@GenericGenerator(name = "demo", strategy = "AUTO")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	
	private String description;
	
	
	public CourseDTO() {
		super();
	}


	public CourseDTO(long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "CourseDTO [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
	
	
}
