package com.example.productertask2.core.result;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataResult<T>{
    private T data;
    private Result result;
    public DataResult(T data , Result result){
        this.data = data;
        this.result = result;
    }
}