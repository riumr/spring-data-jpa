package com.jpaProject.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpaProject.jpa.models.Author;

import jakarta.transaction.Transactional;

public interface AuthorRepository extends JpaRepository<Author,Integer>, JpaSpecificationExecutor<Author> {

    @Transactional
    List<Author> findByNamedQuery(@Param("age") int age);

    @Transactional
    @Modifying
    void updateByNamedQuery(@Param("age") int age);

    // update Author set a.age = :age where a.id = :id
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    // update Author set a.age = 24
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    int updateAllAuthorsAge(int age);

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
