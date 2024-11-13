package com.productservice.productservice.services;

import com.productservice.productservice.dto.FakeStoreProductDto;
import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.models.Product;

public interface ProductService {

    GenericProductDto getProductById(Long id);

//    void getAllProducts();
//    void deleteProductById(Long id);
//    void updateProduct(Long id);
//    void createProduct();
}
