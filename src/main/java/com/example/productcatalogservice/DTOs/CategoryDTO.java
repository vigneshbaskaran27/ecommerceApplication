package com.example.productcatalogservice.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {
    private String name;
    private String description;
}
