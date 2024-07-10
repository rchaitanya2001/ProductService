package org.example.productservice.Services;

import org.example.productservice.Exceptions.InvalidProductIdException;
import org.example.productservice.Models.Category;
import org.example.productservice.Models.Product;
import org.example.productservice.Repositories.CategoryRepository;
import org.example.productservice.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
// @Primary
@Service("selfProductService")


public class SelfProductService implements ProductService{
@Autowired
    private CategoryRepository categoryRepository ;
    private ProductRepository productRepository;
    SelfProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        //fetch product with the given id from DB
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty())
        {
            //throw an exception-->ProductNotFound
            return null;
        }
        Product product = optionalProduct.get();


        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product replaceProduct() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category =product.getCategory();
        if(category.getId() == null)
        {
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }

        return productRepository.save(product);
    }

    @Override
    public void deleteproduct() {

    }
}
