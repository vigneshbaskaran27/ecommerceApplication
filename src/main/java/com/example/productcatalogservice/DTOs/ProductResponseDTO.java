package com.example.productcatalogservice.DTOs;

import com.example.productcatalogservice.models.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponseDTO {
    private Long productId;
    private String productName;
    private String productDescription;
    private CategoryDTO categoryDTO;
    private String imageUrl;
    private double productPrice;
}
