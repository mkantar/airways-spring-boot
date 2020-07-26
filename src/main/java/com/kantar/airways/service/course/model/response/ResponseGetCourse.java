package com.kantar.airways.service.course.model.response;

import com.kantar.airways.common.model.BaseResponse;
import com.kantar.airways.service.course.model.dto.CourseDTO;

public class ResponseGetCourse extends BaseResponse {
	private CourseDTO course;

	public CourseDTO getCourse() {
		return course;
	}

	public void setCourse(CourseDTO course) {
		this.course = course;
	}

}
