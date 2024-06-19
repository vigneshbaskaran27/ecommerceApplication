package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.DTOs.CategoryDTO;
import com.example.productcatalogservice.DTOs.ProductResponseDTO;
import com.example.productcatalogservice.models.Category;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.services.IFakeStoreService;
import com.example.productcatalogservice.services.ProductService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductResponseDTO productResponseDTO;
    @Autowired
    IFakeStoreService fakeStoreService;
    @Autowired
    ProductService productService;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable("id") Long id) {
        //System.out.println(productRequestDTO.getId());
        Product product=fakeStoreService.getProductById(id);
        ProductResponseDTO body = getProductDTO(product);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("called by", "vignesh");
        return new ResponseEntity<>(body, headers, HttpStatus.OK);

    }

    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = fakeStoreService.getAllProducts();
        List<ProductResponseDTO> body = new ArrayList<>();
        try{
            int size= products.size();
            for (int i = 0; i < size; i++) {
                body.add(getProductDTO(products.get(i)));
            }
        }
        catch (IllegalArgumentException ex){
          throw ex;
        }
        return body;
    }
    public void CreateProduct(Long productId)
    {

    }

    @GetMapping("/products/add-all")
    public List<ProductResponseDTO> pushAllProducts()
    {
        //get all the products from fakestore API
        List<ProductResponseDTO> fakeProducts = getAllProducts();
        List<Product> products = new ArrayList<>();

        for(ProductResponseDTO productResponse : fakeProducts)
            products.add(getProductFromDTO(productResponse));
        //insert all the data into our database

        List<Product> newProducts= productService.putAllProducts(products);
        //send back the response
        List<ProductResponseDTO> body = new ArrayList<>();
        for(Product latestProduct : newProducts)
                body.add(getProductDTO(latestProduct));

        return body;

    }

    private ProductResponseDTO getProductDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductId(product.getId());
        productResponseDTO.setProductName(product.getName());
        productResponseDTO.setProductDescription(product.getDescription());
        productResponseDTO.setProductPrice(product.getPrice());
        productResponseDTO.setImageUrl(product.getImageUrl());
        CategoryDTO categoryDTO= new CategoryDTO();
       categoryDTO.setDescription(product.getCategory().getDescription());
       categoryDTO.setName(product.getCategory().getName());
        productResponseDTO.setCategoryDTO(categoryDTO);

        return productResponseDTO;
    }


    private Product getProductFromDTO(ProductResponseDTO productResponseDTO) {
        Product product = new Product();
        product.setId(productResponseDTO.getProductId());
        product.setName(productResponseDTO.getProductName());
        product.setDescription(productResponseDTO.getProductDescription());
        product.setPrice(productResponseDTO.getProductPrice());
        product.setImageUrl(productResponseDTO.getImageUrl());
        Category category = new Category();
        category.setDescription(productResponseDTO.getCategoryDTO().getDescription());
        category.setName(productResponseDTO.getCategoryDTO().getName());
        product.setCategory(category);

        return product;
    }
}

