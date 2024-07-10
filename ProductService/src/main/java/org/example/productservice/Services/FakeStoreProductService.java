package org.example.productservice.Services;

import org.example.productservice.DTOs.FakeStoreProductDto;
import org.example.productservice.Exceptions.InvalidProductIdException;
import org.example.productservice.Models.Category;
import org.example.productservice.Models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")

public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto)
    {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
//        Category category = new Category();
//        category.setTitle(fakeStoreProductDto.getCategory());
//        product.setCategory(category);
        return  product;

    }
    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        //call the fakestore API to get the product with given ID here
        FakeStoreProductDto fakeStoreProductDto =
        restTemplate.getForObject("https://fakestoreapi.com/products/1" + id, FakeStoreProductDto.class);
        if(fakeStoreProductDto == null)
        {
            throw new InvalidProductIdException(id,"Invalid Product ID passed");
        }
        //convert fakestoreProductDto to product object
        if(fakeStoreProductDto == null){return null;}
       return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
         FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products" ,FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto :fakeStoreProductDtos)
        {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
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
        //put method
        //replace the product with given id with input product
        //and return the updated product
        //restTemplate's put method is not as per our requirement, so using internal methods suitable
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product,FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto = restTemplate.execute("https://fakestoreapi.com/carts/7" +id, HttpMethod.POST,requestCallback,responseExtractor);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product createProduct(Product product) {

        return product;
    }

    @Override
    public void deleteproduct() {

    }
}
