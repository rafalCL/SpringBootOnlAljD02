package pl.coderslab.springbootonlaljd02.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ResourceNotFoundException extends RuntimeException {
    private final String errorCode = "CODE1";

    public ResourceNotFoundException(String message) {
        super(message);
    }
    public ResourceNotFoundException(Long id) {
        super(String.format("Resource with %o not found", id));
    }
    public String getErrorCode() {
        return errorCode;
    }
}