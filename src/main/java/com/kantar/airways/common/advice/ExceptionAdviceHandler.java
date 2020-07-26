package com.kantar.airways.common.advice;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.common.exception.NotFoundException;
import com.kantar.airways.common.model.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdviceHandler {

	@ResponseBody
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	BaseResponse businessExceptionHandler(BusinessException ex) {
		BaseResponse response = new BaseResponse();
		response.setSuccess(false);
		response.setErrorCode(ex.getExceptionId().intValue());
		response.setErrorMessage(ex.getMessage());

		return response;
	}

	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	BaseResponse notFoundExceptionHandler(NotFoundException ex) {
		BaseResponse response = new BaseResponse();
		response.setSuccess(false);
		response.setErrorMessage(ex.getMessage());

		return response;
	}

}
