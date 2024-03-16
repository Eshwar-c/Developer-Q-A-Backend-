package com.QA.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping()
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/product")
    public ResponseEntity<Product> SaveProduct(@RequestBody Product product){
        Product newProduct = (Product) productService.SaveProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping("/product/{Questions}")
    public ResponseEntity<Product> getProductById(@PathVariable String Questions) {
        Optional<Product> product = productService.getProductByQuestion(Questions);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
