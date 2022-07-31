package com.example.productertask2.exception;

import com.example.productertask2.core.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class GraphQLExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Result> handle(CustomException exception){
         Result result = Result.errorResult(
                 exception.getMessage()
         );

         HttpStatus status = HttpStatus.BAD_REQUEST;

         return new ResponseEntity<>(
                 result,
                 status
         );
     }
}
