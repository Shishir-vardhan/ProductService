package com.productservice.productservice.inheritencerelations.joindedclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "j_students")
//@PrimaryKeyJoinColumn(name = "id")
public class Student extends User {

    private double psp;

}
