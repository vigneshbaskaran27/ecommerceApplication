package com.example.productcatalogservice.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"}),
        @UniqueConstraint(columnNames = {"id"})
})
public class Category extends BaseClass {

    private String name;
 //   @Column(columnDefinition = "VARCHAR2(2000)")
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> productList = new ArrayList<>();
}