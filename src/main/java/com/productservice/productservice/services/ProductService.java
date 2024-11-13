package com.productservice.productservice.services;

import com.productservice.productservice.dto.FakeStoreProductDto;
import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.models.Product;

import java.util.List;

public interface ProductService {

    GenericProductDto getProductById(Long id);

    List<GenericProductDto> getAllProducts();
//    void deleteProductById(Long id);
//    void updateProduct(Long id);
    GenericProductDto createProduct(GenericProductDto genericProductDto);
}
