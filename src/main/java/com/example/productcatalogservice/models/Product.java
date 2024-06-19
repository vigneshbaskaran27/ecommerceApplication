package com.example.productcatalogservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.Cascade;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
