package com.productservice.productservice.inheritencerelations.joindedclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "j_tas")
//@PrimaryKeyJoinColumn(name = "id")
public class Ta extends User {

    private String ta_session;
}
