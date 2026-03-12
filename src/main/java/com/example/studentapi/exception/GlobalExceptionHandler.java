package com.example.studentapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.studentapi.response.ApiResponse;

import org.springframework.web.bind.MethodArgumentNotValidException;

// import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler {

        // @ExceptionHandler(StudentNotFoundException.class)
        // public ResponseEntity<?> handleNotFound(StudentNotFoundException ex) {

        // return ResponseEntity.status(HttpStatus.NOT_FOUND)
        //         .body(Map.of(
        //                 "timestamp", LocalDateTime.now(),
        //                 "error", ex.getMessage()
        //         ));
        // }
        @ExceptionHandler(StudentNotFoundException.class)
        public ResponseEntity<ApiResponse<Object>> handleStudentNotFound(StudentNotFoundException ex) {

                ApiResponse<Object> response = new ApiResponse<>(
                        false,
                        ex.getMessage(),
                        null
                );

                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        // @ExceptionHandler(DuplicateStudentException.class)
        // public ResponseEntity<?> handleDuplicate(DuplicateStudentException ex) {

        // return ResponseEntity.status(HttpStatus.CONFLICT)
        //         .body(Map.of(
        //                 "timestamp", LocalDateTime.now(),
        //                 "error", ex.getMessage()
        //         ));
        // }
        @ExceptionHandler(DuplicateStudentException.class)
        public ResponseEntity<ApiResponse<Object>> handleDuplicateStudent(DuplicateStudentException ex) {

                ApiResponse<Object> response = new ApiResponse<>(
                        false,
                        ex.getMessage(),
                        null
                );

                return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        fieldError -> fieldError.getField(),
                        fieldError -> fieldError.getDefaultMessage()
                ));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errors);
        }

        // @ExceptionHandler(MethodArgumentNotValidException.class)
        // public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationErrors(MethodArgumentNotValidException ex) {

        // Map<String, String> errors = ex.getBindingResult()
        //         .getFieldErrors()
        //         .stream()
        //         .collect(Collectors.toMap(
        //                 fieldError -> fieldError.getField(),
        //                 fieldError -> fieldError.getDefaultMessage(),
        //                 (msg1, msg2) -> msg1
        //         ));

        // ApiResponse<Map<String, String>> response =
        //         new ApiResponse<>(false, "Validation failed", errors);

        // return ResponseEntity
        //         .status(HttpStatus.BAD_REQUEST)
        //         .body(response);
        // }
    
}