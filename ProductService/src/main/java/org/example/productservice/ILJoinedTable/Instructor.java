package org.example.productservice.ILJoinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_Instructor")
public class Instructor extends User {
    private String specialization;
}
