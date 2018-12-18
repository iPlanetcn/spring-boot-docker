package com.phenix.study.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Customer Entity
 *
 * @author john
 * @since 2017-06-09
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
