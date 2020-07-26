package com.kantar.airways.controller.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kantar.airways.common.exception.AirwayBusinessException;
import com.kantar.airways.service.course.CourseService;
import com.kantar.airways.service.course.model.request.RequestCreateCourse;
import com.kantar.airways.service.course.model.request.RequestGetAllCourses;
import com.kantar.airways.service.course.model.request.RequestGetCourse;
import com.kantar.airways.service.course.model.response.ResponseCreateCourse;
import com.kantar.airways.service.course.model.response.ResponseGetAllCourses;
import com.kantar.airways.service.course.model.response.ResponseGetCourse;

@RestController
@RequestMapping(path = "course")
public class CourseController {
	
	@Autowired
	CourseService service;
	
	@GetMapping
	public ResponseGetAllCourses getAllCourses() {
		return service.getAllCourses(new RequestGetAllCourses());
	}
	
	@GetMapping("/{id}")
	public ResponseGetCourse getCourse(@PathVariable Long id) {
		return service.getCourse(new RequestGetCourse(id));
	}
	
	@PostMapping
	public ResponseCreateCourse createCourse(@RequestBody RequestCreateCourse request) throws AirwayBusinessException {
		return service.createCourse(request);
	}
	
}
