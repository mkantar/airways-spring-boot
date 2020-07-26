package com.kantar.airways.common.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kantar.airways.common.exception.AirwayBusinessException;
import com.kantar.airways.common.exception.AirwayNotFoundException;
import com.kantar.airways.common.model.BaseResponse;

@ControllerAdvice
public class AirwayBusinessExceptionAdvice {

	@ResponseBody
	@ExceptionHandler(AirwayBusinessException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	BaseResponse businessExceptionHandler(AirwayBusinessException ex) {
		BaseResponse response = new BaseResponse();
		response.setSuccess(false);
		response.setErrorCode(ex.getExceptionId().intValue());
		response.setErrorMessage(ex.getMessage());
		
		return response;
	}
	
	@ResponseBody
	@ExceptionHandler(AirwayNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	BaseResponse notFoundExceptionHandler(AirwayNotFoundException ex) {
		BaseResponse response = new BaseResponse();
		response.setSuccess(false);
		response.setErrorMessage(ex.getMessage());
		
		return response;
	}

}
