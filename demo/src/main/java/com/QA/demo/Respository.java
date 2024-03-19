package com.QA.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Respository extends JpaRepository<Product,Long> {


    Optional<Product> findAll(String questions);

    Optional<Product> findBy(String questions);

    Optional<Product> findById(String questions);

    Optional<Product> findByQuestions(String questions);
}
