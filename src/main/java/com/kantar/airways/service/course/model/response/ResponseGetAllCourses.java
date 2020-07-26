package com.kantar.airways.service.course.model.response;

import java.util.List;

import com.kantar.airways.common.model.BaseResponse;
import com.kantar.airways.service.course.model.dto.CourseDTO;

public class ResponseGetAllCourses extends BaseResponse {
	private List<CourseDTO> courses;

	public List<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDTO> courses) {
		this.courses = courses;
	}

}
