package com.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.entity.CourseDTO;

@Repository
public interface CourseDAO extends JpaRepository<CourseDTO, Long>{

}
