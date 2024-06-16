package com.example.productcatalogservice.DTOs;

import com.example.productcatalogservice.models.BaseClass;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProductRequestDTO extends BaseClass {
    private Long id;
}
