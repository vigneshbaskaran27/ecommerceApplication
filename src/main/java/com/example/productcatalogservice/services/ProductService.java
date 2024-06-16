package com.example.productcatalogservice.services;

import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public List<Product> putAllProducts(List<Product> products) {

       // List<Product> updateList = productRepository.putAll(products);
//        int size=List.size();
//        if(size==0) {
//            throw new ArrayStoreException("Products haven't added into the database");
//        }

          return productRepository.saveAll(products);


    }



}
