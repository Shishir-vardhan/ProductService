package com.productservice.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    List<Product> products;
}
