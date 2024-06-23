package org.example.productservice.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private Long id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String image;
}
