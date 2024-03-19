package com.QA.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final Respository repository;

    @Autowired
    public ProductService(Respository repository) {
        this.repository = repository;
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductByQuestions(String questions) {
        return repository.findByQuestions(questions);
    }

    public Product updateProduct(String questions, Product updatedProduct) {
        Optional<Product> existingProduct = repository.findByQuestions(questions);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setQuestions(updatedProduct.getQuestions());
            product.setAnswers(updatedProduct.getAnswers());
            return repository.save(product);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    public Optional<Product> getProductByProduct(String productId) {
        return repository.findById(productId);
    }
}