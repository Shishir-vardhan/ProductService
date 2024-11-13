package com.productservice.productservice.controllers;

import com.productservice.productservice.dto.FakeStoreProductDto;
import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    public ProductService productService;

    @Autowired
    //Constructor injection
    public ProductController(@Qualifier("fakeStoreProductServiceImpl") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        //Below code used to direct it to service.To use it we need an object of the service and we can implement using dependency injection
        // Call the FakeStoreProductService getProductById() method.
        return productService.getProductById(id);
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }
//
//    @GetMapping("/{id}")
//    public void deleteProductById(@PathVariable("id") Long id) {
//
//    }
//
//    @GetMapping
//    public void createProduct() {}
//
//    @GetMapping("/{id}")
//    public void updateProductById(@PathVariable("id") Long id) {
//
//    }

    /*3 types of injection:-

     1. Constructor injection
     2.
     3. Setter injection


     */
}
