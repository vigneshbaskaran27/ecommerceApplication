package com.example.productcatalogservice.services;

import com.example.productcatalogservice.DTOs.CategoryDTO;
import com.example.productcatalogservice.DTOs.FakeProductDTO;
import com.example.productcatalogservice.client.FakeStoreClient;
import com.example.productcatalogservice.models.Category;
import com.example.productcatalogservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FakeStoreService implements IFakeStoreService {

    @Autowired
    private  RestTemplateBuilder restTemplateBuilder;
    @Autowired
    FakeProductDTO fakeProductDTO;
    @Autowired
    FakeStoreClient fakeStoreClient;


    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        List<Product> products = new ArrayList<>();
        try{
            FakeProductDTO[] fakeProductDTOS = restTemplate.getForObject("https://fakestoreapi.com/products", FakeProductDTO[].class);


            for(FakeProductDTO fakeProductDTO : fakeProductDTOS){

                products.add(getProduct(fakeProductDTO));
            }

        }
        catch (Exception e){
//            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Product CreateProduct(Product product) {
        return null;
    }

    @Override
    public Product getProductById(Long productId) {

        return getProduct(fakeStoreClient.getFakeProductById(productId));

    }

    private Product getProduct(FakeProductDTO fakeProductDTO) {
        Product product = new Product();
        product.setId(fakeProductDTO.getId());
        product.setName(fakeProductDTO.getTitle());
        product.setDescription(fakeProductDTO.getDescription());
        product.setPrice(fakeProductDTO.getPrice());
        Category category = new Category();
        category.setName(fakeProductDTO.getCategory());
        // category.setDescription(fakeProductDTO.getCategory().getDescription());
        product.setCategory(category);
        product.setImageUrl(fakeProductDTO.getImageUrl());

        return product;

    }
}
