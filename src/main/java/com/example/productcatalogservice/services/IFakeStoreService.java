package com.example.productcatalogservice.services;

import com.example.productcatalogservice.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IFakeStoreService {



     List<Product> getAllProducts();

     Product CreateProduct(Product product);


    Product getProductById(Long productId);
}


