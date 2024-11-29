package com.productservice.productservice.controllers;

import com.productservice.productservice.dto.ExceptionDto;
import com.productservice.productservice.dto.FakeStoreProductDto;
import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.exception.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    public ProductService productService;

//    @Autowired
//    //Constructor injection
//    public ProductController(@Qualifier("fakeStoreProductServiceImpl") ProductService productService) {
//        this.productService = productService;
//    }

//    @GetMapping("/{id}")
//    public GenericProductDto getProductById(@PathVariable("id") Long id) throws Exception {
//        //Below code used to direct it to service.To use it we need an object of the service and we can implement using dependency injection
//        // Call the FakeStoreProductService getProductById() method.
//        return productService.getProductById(id);
//    }

    /*
    Commenting above method getProductById because it's calling to fakestore api and interacting with it's database.
    We want api to interact with our database. For which -
    1.To test and check the issues for db migration initialization and hibernate.ddl-auto= none functionality.
    2.Created SelfProductServiceImpl and making changes to controller so that it interact with our db.s
     */
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws Exception {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {
        return productService.createProduct(genericProductDto);
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id) {
        return productService.deleteProductById(id);
    }


//    @PatchMapping("/{id}")
//    public GenericProductDto updateProductById(@RequestBody GenericProductDto genericProductDto, @PathVariable("id") Long id) {
//        return productService.updateProductById(genericProductDto,id);
//    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ExceptionDto handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
//
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
//        return exceptionDto;
//    }

    // Another Way to create ExceptionHandler common for all the controller has done in ProductControllerAdvices using @ControllerAdvice.
//    @ExceptionHandler(ProductNotFoundException.class)
//    public void handleProductNotFoundException()
//    {
//        System.out.println(HttpStatus.NOT_FOUND);
//    }




    /*3 types of injection:-

     1. Constructor injection
     2. Field injection
     3. Setter injection


     */
}
