package com.example.productcatalogservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.Cascade;


@Data
@Entity
public class Product extends BaseClass{
    private String name ;
  //  @Column(columnDefinition = "VARCHAR2(2000)")
    private String description;
    private String ImageUrl;
    private double price;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
}
