package com.productservice.productservice.services;

import com.productservice.productservice.dto.FakeStoreProductDto;
import com.productservice.productservice.dto.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String sepecificProductUrl ="https://fakestoreapi.com/products/{id}";
    private String genericProductUrl =  "https://fakestoreapi.com/products";
    private String createProductUrl =  "https://fakestoreapi.com/products";

    FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setImage(fakeStoreProductDto.getImage());

        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(Long id) {
        //Below code should have fakeStore Api call/ Integrate the fakeStore Api.

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(sepecificProductUrl, FakeStoreProductDto.class, id);

        //Adding extra layer in case there is a change in the attribute of an api

        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public List<GenericProductDto> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(genericProductUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(responseEntity.getBody());
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            genericProductDtos.add(convertToGenericProductDto(fakeStoreProductDto));
        }


        return genericProductDtos;
    }
//
//    @Override
//    public void deleteProductById(Long id) {
//
//    }
//
//    @Override
//    public void updateProduct(Long id) {
//
//    }
//
    @Override
        public GenericProductDto createProduct(GenericProductDto genericProductDto) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(createProductUrl,genericProductDto,FakeStoreProductDto.class);

        return convertToGenericProductDto(responseEntity.getBody());

    }
}
