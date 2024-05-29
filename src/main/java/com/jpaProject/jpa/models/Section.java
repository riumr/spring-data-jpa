package com.jpaProject.jpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Section {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int sectionOrder;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
