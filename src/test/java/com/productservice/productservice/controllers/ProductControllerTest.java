package com.productservice.productservice.controllers;

import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.exception.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ProductControllerTest {

    @MockBean
    ProductService productService;
    @Autowired
    private ProductController productController;

    @Test
    void testAddOnePlusOneIsTwoOrNot()
    {
//        assert(2 == 1+1);
//        assertEquals(2, 1+1, "1 plus 1 is 2");
        assertNotNull(2);
    }


    /* Writing test case for getProductById
        1. getProductById internally calling product service. For testing purpose we don't want to call product service. We'll mock it.
            Mock means whatever the o/p we get from productService.getProductById(id), we'll give by our self therefore no need to go product
            service to getProductById.
        2. Controller depends on productService and thus we need to create that instance after class name and Mock it.
            create ProductService productService and annotate with @Mockbean.
        3. When you calling productController.getProductById() internally it depends on productService.getProductById()-> Now we already mock
            the product service -> using when().thenReturn() will tell application when (proudctService.getProductById()) gets called thenReturn
            (some value) instead of actual calling productService.getProductById(),
         4. Using assert we can test the getProductById() method of controller class.
     */

    @Test
    void testGetProductById() throws Exception {
        when(productService.getAllProducts()).thenReturn(null);
        assertNull(productController.getAllProducts());
        assertEquals(productController.getAllProducts(), null);
    }


    @Test
    void testGetProudctByIdMocking() throws Exception {
        GenericProductDto genericProductDto = new GenericProductDto();
        when(productService.getProductById(1L)).thenReturn(genericProductDto);
        assertEquals(genericProductDto, productController.getProductById(1L));

        // For below two cases the test case get failed because the expected and actual output is different.
//        GenericProductDto genericProductDto1 = productService.getProductById(100L);
//        assertEquals(genericProductDto1, productController.getProductById(1L));
//
//        GenericProductDto genericProductDto2 = new GenericProductDto();
//        assertEquals(genericProductDto2, productController.getProductById(100L));
    }

}
