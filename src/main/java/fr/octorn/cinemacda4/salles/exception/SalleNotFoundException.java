package fr.octorn.cinemacda4.salles.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SalleNotFoundException extends RuntimeException {
    public SalleNotFoundException(String message) {
        super(message);
    }
}

