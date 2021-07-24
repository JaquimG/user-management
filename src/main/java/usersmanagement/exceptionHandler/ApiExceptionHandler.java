package usersmanagement.exceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(
			TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ErrorMessage error = new ErrorMessage(); 
		error.setStatus(status.value());
		error.setDate(LocalDateTime.now());
		error.setTitle("Incorrect http request. Please choose the correct http request.");
		
		return handleExceptionInternal(ex,error, headers, status, request);
	}
	/*
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	protected ResponseEntity<Object> constraintViolation(
			SQLIntegrityConstraintViolationException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ErrorMessage error = new ErrorMessage(); 
		error.setStatus(status.value());
		error.setDate(LocalDateTime.now());
		error.setTitle("Incorrect http request. Please choose the correct http request.");
		
		return handleExceptionInternal(ex,error, headers, status, request);
	}*/
}
