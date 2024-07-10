package org.example.productservice.ILTablePerClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;

}
