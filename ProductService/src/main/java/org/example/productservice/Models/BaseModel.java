package org.example.productservice.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
//@Entity
@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createAt;
    private Date updatedAt;
}
//basemodel is not a real entity