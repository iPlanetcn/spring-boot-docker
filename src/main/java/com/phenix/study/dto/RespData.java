package com.phenix.study.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class RespData<T> extends Resp {
    private T data;

    public RespData(Integer code, String message, T data) {
        super(code, message);
        this.data = data;
    }
}
