package com.productservice.productservice.services;

import com.productservice.productservice.dto.FakeStoreProductDto;
import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.exception.ProductNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductUrl ="https://fakestoreapi.com/products/{id}";
    private String genericProductUrl =  "https://fakestoreapi.com/products";

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
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        //Below code should have fakeStore Api call/ Integrate the fakeStore Api.

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product with id : "+ id +" doesn't exist.");
        }

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

    @Override
        public GenericProductDto createProduct(GenericProductDto genericProductDto) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(genericProductUrl,genericProductDto,FakeStoreProductDto.class);

        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        // Below code work if we have to delete the data only.
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        restTemplate.delete(sepecificProductUrl, id);

        // This below code will delete the data and give the data it deleted.
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return convertToGenericProductDto(responseEntity.getBody());
    }


//    @Override
//    public GenericProductDto updateProductById(GenericProductDto genericProductDto,Long id) {
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.exchange(specificProductUrl,HttpMethod.PUT, genericProductDto, FakeStoreProductDto.class, id);
//
//        return convertToGenericProductDto(responseEntity.getBody());
//    }


}
