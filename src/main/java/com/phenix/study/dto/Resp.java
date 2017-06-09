package com.phenix.study.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Resp {
    private Integer code;
    private String message;
}
