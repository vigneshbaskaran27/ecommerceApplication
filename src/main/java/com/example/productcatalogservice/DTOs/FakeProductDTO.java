package com.example.productcatalogservice.DTOs;

import com.example.productcatalogservice.models.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FakeProductDTO {

    private long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;


}
