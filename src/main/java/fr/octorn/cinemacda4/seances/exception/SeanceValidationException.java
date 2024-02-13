package fr.octorn.cinemacda4.seances.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SeanceValidationException extends RuntimeException {
    public SeanceValidationException(String message) {
        super(message);
    }
}

