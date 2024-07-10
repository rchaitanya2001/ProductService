package org.example.productservice.Controllers;

import org.example.productservice.Exceptions.InvalidProductIdException;
import org.example.productservice.Exceptions.ProductControllerSpecificException;
import org.example.productservice.Models.Product;
import org.example.productservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService ;
    ProductController(@Qualifier("selfProductService") ProductService productService)
    {
        this.productService =productService;
    }

    //localhost :8080/products/10
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id")Long id) throws InvalidProductIdException
    {
       Product product =null;
       try {

           product = productService.getProductById(id);
       }
       catch (RuntimeException e)
       {
          System.out.println("Something went wrong");
          return new ResponseEntity<>(product,HttpStatus.OK);
       }
        return new ResponseEntity<>(product, HttpStatus.FORBIDDEN);
    }
     //localhost :8080/products
    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product)
    {
        return productService.createProduct(product);
    }
    //partial update
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id")Long id, @RequestBody Product product)
    {

        return productService.updateProduct(id,product);
    }
    //replace product
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id")Long id, @RequestBody Product product)
    {
        return new Product();
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id")Long id, @RequestBody Product product)
    {}
    @ExceptionHandler(ProductControllerSpecificException.class)
    public ResponseEntity<Void> handleProductControllerSpecificException()
    {
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
