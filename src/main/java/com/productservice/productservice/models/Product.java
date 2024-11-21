package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // This tells Hibernate to make a table out of this class
public class Product extends BaseModel {

    private String title;
    private String description;
    private int price;
    private String imageUrl;


    //Category isn't a primitive attribute, it's a relation here.
    @ManyToOne
    private Category category;
}



/*
        1           1
    product  ->  category
        m           1
       relation is - m:1
 */