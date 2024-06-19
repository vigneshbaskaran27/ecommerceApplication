package com.example.productcatalogservice.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
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