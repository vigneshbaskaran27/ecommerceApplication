package com.example.productcatalogservice.controllerTest;

import com.example.productcatalogservice.DTOs.ProductResponseDTO;
import com.example.productcatalogservice.controllers.ProductController;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.services.IFakeStoreService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    ProductController productController;

    @MockBean
    IFakeStoreService iFakeStoreService;


    @Test
    void Test_GetProductById_whenValidIdIsPassed_ReturnSucessResponse()
    {
        //ARRANGE as these are the required dependency for out test
        Product product = new Product();
        product.setId(1l);
        product.setName("Iphone");
        when(iFakeStoreService.getProductById(any(Long.class))).thenReturn(product);

        //ACT
        ResponseEntity<ProductResponseDTO> productResponseDTO=productController.getProduct(1l);

        //ASSERT

        assertNotNull(productResponseDTO);
        assertEquals(1l , productResponseDTO.getBody().getProductId());
        assertEquals("Iphone", productResponseDTO.getBody().getProductName());

    }

}
