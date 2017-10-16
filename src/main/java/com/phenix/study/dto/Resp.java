package com.phenix.study.dto;

/**
 * Response Entity
 *
 * @author john
 * @since 2017-10-16
 */
public class Resp {
    private Integer code;
    private String message;

    Resp() {
    }

    public Resp(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
