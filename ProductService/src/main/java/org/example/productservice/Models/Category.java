package org.example.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel {

    private String title;
//    private double price;
//
//    private String description;
//    private String image;
}
