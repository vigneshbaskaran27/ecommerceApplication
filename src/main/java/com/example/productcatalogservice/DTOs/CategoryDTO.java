package com.example.productcatalogservice.DTOs;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CategoryDTO {
    private String name;
    private String description;
}
