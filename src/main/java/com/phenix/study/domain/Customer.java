package com.phenix.study.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Customer Entity
 *
 * @author john
 * @since 2017-06-09
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
}
