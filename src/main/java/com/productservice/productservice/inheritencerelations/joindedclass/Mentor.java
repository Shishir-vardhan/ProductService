package com.productservice.productservice.inheritencerelations.joindedclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "j_mentors")
//@PrimaryKeyJoinColumn(name = "id")
public class Mentor extends User {

    private double avgRating;
}
