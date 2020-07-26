package com.kantar.airways.service.course;

import com.kantar.airways.common.exception.AirwayBusinessException;
import com.kantar.airways.service.course.model.request.RequestCreateCourse;
import com.kantar.airways.service.course.model.request.RequestGetAllCourses;
import com.kantar.airways.service.course.model.request.RequestGetCourse;
import com.kantar.airways.service.course.model.response.ResponseCreateCourse;
import com.kantar.airways.service.course.model.response.ResponseGetAllCourses;
import com.kantar.airways.service.course.model.response.ResponseGetCourse;

public interface CourseService {
	
	ResponseGetAllCourses getAllCourses(RequestGetAllCourses request);
	
	ResponseGetCourse getCourse(RequestGetCourse request);
	
	ResponseCreateCourse createCourse(RequestCreateCourse request) throws AirwayBusinessException;
}
