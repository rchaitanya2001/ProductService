package org.example.productservice.ILTablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TA extends User {
    private int numberOfSessions;
    private double avgRating;
}
