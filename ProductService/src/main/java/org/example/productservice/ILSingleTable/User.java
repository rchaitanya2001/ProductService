package org.example.productservice.ILSingleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "singleTable_users")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
