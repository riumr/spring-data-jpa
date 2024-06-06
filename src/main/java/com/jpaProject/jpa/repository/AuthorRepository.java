package com.jpaProject.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaProject.jpa.models.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    // select * from Author where first_name = fn
    List<Author> findAllByFirstName(String fn);
    
    // select * from Author where first_name = fn
    List<Author> findAllByFirstNameIgnoreCase(String fn);
    
    // select * from Author where first_name like '%fn%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    // select * from Author where first_name like 'fn%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

    // select * from Author where first_name like '%fn'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

    // select * from Author where first_name in (...)
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);
}
