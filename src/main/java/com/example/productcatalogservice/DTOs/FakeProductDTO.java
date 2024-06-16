package com.example.productcatalogservice.DTOs;

import com.example.productcatalogservice.models.Category;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class FakeProductDTO {

    private long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;


}
