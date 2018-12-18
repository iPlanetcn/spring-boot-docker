package com.phenix.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response Entity
 *
 * @author john
 * @since 2017-10-16
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Resp {
    private Integer code;
    private String message;
}
