package com.javaweb.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.dto.ErrorDetailReponse;
import com.javaweb.dto.ValidateDataBuildingException;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ValidateDataBuildingException.class)
	public ResponseEntity<Object> handleValidateDataBuildingException(ValidateDataBuildingException ex){
		
		ErrorDetailReponse errorDetailResponse = new ErrorDetailReponse();
		errorDetailResponse.setError(ex.getMessage());
		
		return new ResponseEntity<Object>(errorDetailResponse, HttpStatus.BAD_REQUEST); // tham so dau tien tra ve chi tiet loi, tham so thu 2 fe tra ve sai 
	}
	@ExceptionHandler(Exception.class)
		public ResponseEntity<Object> handleException(Exception ex){
		
		ErrorDetailReponse errorDetailResponse = new ErrorDetailReponse();
		errorDetailResponse.setError(ex.getMessage());
		
		return new ResponseEntity<Object>(errorDetailResponse, HttpStatus.INTERNAL_SERVER_ERROR); // Loi ve phia sever
	}
}
