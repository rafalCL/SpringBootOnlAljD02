package pl.coderslab.springbootonlaljd02.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.time.LocalDateTime;

// poniższa klasa jest definicją komunikatu który chcemy zwracać z API naszej aplikacji
// {
//  "error": {
//    "timestamp": "03-03-2023 03:23:03",
//    "message": "Cartoon already exist",
//    "code": "VALIDATE_12"
//  }
//}

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName(value = "error")
public
class CustomError {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String code;

    private CustomError() {
        timestamp = LocalDateTime.now();
    }

    public CustomError(Throwable ex) {
        this();
        this.message = ex.getLocalizedMessage();
    }
}