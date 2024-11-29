package com.productservice.productservice.services;

import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
public class SelfProductServiceImpl implements ProductService{

    ProductRepository productRepository;

    SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws Exception {
        GenericProductDto genericProductDto = new GenericProductDto();
        Optional<Product> products = productRepository.findById(UUID.fromString("6d0033a7-44b3-4482-8c41-27db8f621792"));
        Product product = products.get();

        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setImage(product.getImageUrl());
        genericProductDto.setPrice(0);

        return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return List.of();
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }
}
