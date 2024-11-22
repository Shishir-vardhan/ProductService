package com.productservice.productservice.inheritencerelations.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "user_id",
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "user")
//DiscriminatorColumn and DiscriminatorValue is used to change first column name and type of value it stored in user table.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
