package com.phenix.study.dto;

/**
 * Response entity with T
 *
 * @author john
 * @since 2017-10-16
 */
public class RespData<T> extends Resp {
    private T data;

    public RespData() {
    }

    public RespData(Integer code, String message, T data) {
        super(code, message);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
