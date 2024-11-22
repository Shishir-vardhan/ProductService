package com.productservice.productservice.inheritencerelations.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_tas")
@DiscriminatorValue(value = "ta")
public class Ta extends User {

    private String ta_session;
}
