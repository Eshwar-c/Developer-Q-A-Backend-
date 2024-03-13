package com.QA.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
@Repository
public interface Respository extends JpaRepository<Product,Long> {


}
