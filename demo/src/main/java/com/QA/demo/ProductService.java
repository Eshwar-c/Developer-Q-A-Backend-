package com.QA.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final  Respository respository;
@Autowired
    public ProductService(Respository respository) {
        this.respository = respository;
    }

    public Object SaveProduct(Product product){
       return (Product) respository.save(product);
    }

    public List<Product> getAllProducts(){
        return respository.findAll();
    }

    public Optional <Product> getProductByQuestion(String Questions){
        return (Optional<Product>) respository.findBy(Questions);
    }

    public Product updateProduct(String Questions, Product updateProduct){
        Optional<Product> existingProduct = respository.findBy(Questions);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            ClassLoader updatedProduct = null;
            product.setQuestions(updatedProduct.getClass());
            product.setAnswers(String.valueOf(updatedProduct.getClass()));
            return (Product) respository.save(product);
        } else {
            throw new RuntimeException("Product not found");
        }
    }


}
