package com.phenix.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response entity with T
 *
 * @author john
 * @since 2017-10-16
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RespData<T> extends Resp {
    private T data;

    public RespData(Integer code, String message, T data) {
        super(code, message);
        this.data = data;
    }
}
