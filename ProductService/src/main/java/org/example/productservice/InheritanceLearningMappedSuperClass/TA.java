package org.example.productservice.InheritanceLearningMappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="msc_TA")
public class TA extends User {
    private int numberOfSessions;
    private double avgRating;
}
