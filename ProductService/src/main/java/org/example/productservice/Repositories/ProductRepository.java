package org.example.productservice.Repositories;

import org.example.productservice.Models.Category;
import org.example.productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository <Product,Long> {//<wch table to interact with,data type of the primary key>

    Optional<Product> findById(Long id);//declaration is enough, JPA will take care
    //to avoid null pointer exception, we''ll use Optional
    Optional<Product> findByTitleAndDescription(String title, String Description);
    List<Product> findByTitleContaining(String word);//this uses like operator
    List<Product> findTopThreeByTitle(String title);
    Optional<Product> findByCategory(Category category);
    void deleteById(Long id);
    void deleteByTitle(String title);
    Product save(Product product);
//    @Query("CustomQuery")//HQL-->Hibernate Query Language
//    Optional<Product> someRandomQuery();
}
/*Product Repository-->Product
Product findById(id) ==>select *from product where id = <id>
findAll()=> select*from product
 */