package org.example.productservice.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
//    @Id
//    private Long id; -->moved to basemodel
    private String title;
    private Double price;
    private String description;
    private String image;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;//if one product belongs to many categories, we could've taken List<Categories>
}
// 1----- 1

//product--category
//M------1