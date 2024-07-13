package org.example.productservice;

import org.example.productservice.Models.Category;
import org.example.productservice.Models.Product;
import org.example.productservice.Repositories.CategoryRepository;
import org.example.productservice.Repositories.ProductRepository;
import org.example.productservice.Repositories.ProductWithIdAndTitle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Test
	void contextLoads() {
	}
	@Test
	public void testQueries()
	{
//		List<ProductWithIdAndTitle> products = productRepository.someRandomQuery();
//		for(ProductWithIdAndTitle product : products)
//		{
//			System.out.println(product.getId());
//			System.out.println(product.getTitle());
//		}
 		//ProductWithIdAndTitle product = productRepository.doSomething(1L);
//		Product prod1 = productRepository.doSomethingSql();
//		System.out.println(prod1.getId());
//		categoryRepository.deleteById(152L);
		Optional<Category> optionalCategory = categoryRepository.findById(252L);
		Category category = optionalCategory.get();
		System.out.println("Fetched Category");
		List<Product> products = category.getProducts();
		System.out.println("Debug");
	}
}
