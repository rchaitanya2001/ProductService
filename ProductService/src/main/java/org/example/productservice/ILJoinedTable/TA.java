package org.example.productservice.ILJoinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_TA")
public class TA extends User {
    private int numberOfSessions;
    private double avgRating;
}
