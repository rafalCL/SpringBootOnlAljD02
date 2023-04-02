package pl.coderslab.springbootonlaljd02.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    // here we can add validator handler from previous module

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<CustomError> handleEntityNotFound(ResourceNotFoundException ex) {
        CustomError apiError = new CustomError(ex);
        apiError.setMessage(ex.getMessage());
        apiError.setCode(ex.getErrorCode());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Object> handleIllegalArgumentException(ResourceNotFoundException ex) {
        CustomError apiError = new CustomError(ex);
        apiError.setMessage(ex.getMessage());
        apiError.setCode(ex.getErrorCode());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}