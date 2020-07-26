package com.kantar.airways.service.course.model.response;

import com.kantar.airways.common.model.BaseResponse;

public class ResponseCreateCourse extends BaseResponse {
	private Long courseId;

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

}
