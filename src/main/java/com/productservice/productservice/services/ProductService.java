package com.productservice.productservice.services;

import com.productservice.productservice.dto.GenericProductDto;

import java.util.List;

public interface ProductService {

    GenericProductDto getProductById(Long id);

    List<GenericProductDto> getAllProducts();

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    GenericProductDto deleteProductById(Long id);

//    GenericProductDto updateProductById(Long id);
}

