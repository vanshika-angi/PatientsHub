package com.hub.patients.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatientExceptionHandler {

    @ExceptionHandler(value = {PatientNotFoundException.class})
    public ResponseEntity<Object> handlePatientException
            (PatientNotFoundException patientNotFoundException)
    {
        PatientException patientException = new PatientException(
                patientNotFoundException.getMessage(),
                patientNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(patientException,HttpStatus.NOT_FOUND);
    }
}
