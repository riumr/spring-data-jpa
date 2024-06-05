package com.jpaProject.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaProject.jpa.models.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    List<Author> findAllByFirstName(String fn);
}
