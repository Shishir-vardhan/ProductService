package com.productservice.productservice.inheritencerelations.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentors")
@DiscriminatorValue(value = "mentor")
public class Mentor extends User {

    private double avgRating;
}
