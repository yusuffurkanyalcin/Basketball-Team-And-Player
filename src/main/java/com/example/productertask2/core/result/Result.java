package com.example.productertask2.core.result;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Result {
    private String message;
    private HttpStatus status;

    public Result(String message,HttpStatus status){
        this.status=status;
        this.message=message;
    }

    public static Result successResult(String message){
        return new Result(message,HttpStatus.OK);
    }

    public static Result errorResult(String message){
        return new Result(message,HttpStatus.BAD_REQUEST);
    }
}
