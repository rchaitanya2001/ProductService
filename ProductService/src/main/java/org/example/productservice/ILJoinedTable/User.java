package org.example.productservice.ILJoinedTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Getter
@Setter
@Entity(name = "jt_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private Long userId;
    private String name;
    private String email;
    private String password;

}
