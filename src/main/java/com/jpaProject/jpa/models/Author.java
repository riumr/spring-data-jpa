package com.jpaProject.jpa.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.TableGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue
    // (strategy = GenerationType.TABLE,generator = "author_id_gen")
    // @SequenceGenerator(name = "author_sequence",sequenceName = "author_sequence",allocationSize = 1)
    // @TableGenerator(name = "author_id_gen", table = "id_generator",
    //                 pkColumnName = "id_name",valueColumnName = "id_value",allocationSize = 1)
    private Integer id;
    @Column(name = "f_name",length = 35)
    private String firstName;
    
    private String lastName;
    @Column(unique=true, nullable = false)
    private String email;
    private int age;
    @Column(updatable = false, nullable = false)
    private LocalDate createdAt;
    @Column(insertable = false)
    private LocalDate lastModified;
}
