package org.example.productservice.Services;

import org.example.productservice.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

//the actual business logic will go into service layer
//entry point of code is control layer

public interface ProductService {
    Product getProductById(Long id);
    List<Product>getAllProducts();
    Product updateProduct();
    Product replaceProduct();
    Product ccreateProduct();
    void deleteproduct();
}
