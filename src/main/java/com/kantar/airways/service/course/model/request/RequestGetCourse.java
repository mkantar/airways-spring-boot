package com.kantar.airways.service.course.model.request;

import com.kantar.airways.common.model.BaseRequest;

public class RequestGetCourse extends BaseRequest {
	private Long id;

	public RequestGetCourse() {
		super();
	}

	public RequestGetCourse(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
