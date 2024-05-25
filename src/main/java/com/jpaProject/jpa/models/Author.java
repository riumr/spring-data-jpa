package com.jpaProject.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private int age;
}
