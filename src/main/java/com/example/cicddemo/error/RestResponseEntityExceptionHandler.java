package com.example.cicddemo.error;

import com.example.cicddemo.note.NoteDoesNotExistException;
import com.example.cicddemo.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler{
    @ExceptionHandler(UserNotFoundException.class)
public ResponseEntity<ErrorMessage> userNotFoundException(UserNotFoundException exception){
    ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
    return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
}
@ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ErrorMessage> duplicateEmailExistsException(DuplicateException exception){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.CONFLICT,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
}
@ExceptionHandler(NoteDoesNotExistException.class)
    public ResponseEntity<ErrorMessage> noteNotFoundException(NoteDoesNotExistException exception){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
}
}
