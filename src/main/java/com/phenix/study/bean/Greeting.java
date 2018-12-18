package com.phenix.study.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Greeting
 *
 * @author john
 * @since 2017-10-16
 */
@AllArgsConstructor
@Getter
public class Greeting {
    private final long id;
    private final String content;
}

