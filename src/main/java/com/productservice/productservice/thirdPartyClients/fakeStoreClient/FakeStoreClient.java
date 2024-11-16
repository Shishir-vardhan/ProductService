package com.productservice.productservice.thirdPartyClients.fakeStoreClient;

import com.productservice.productservice.dto.FakeStoreProductDto;
import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.exception.ProductNotFoundException;
import com.productservice.productservice.services.FakeStoreProductServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreClient {

    private RestTemplateBuilder restTemplateBuilder;

//     No need to use constant value. Call it from application.properties
//    private String specificProductUrl ="https://fakestoreapi.com/products/{id}";
//    private String genericProductUrl =  "https://fakestoreapi.com/products";

    private String fakeStoreUrl;
    private String pathForProducts;
    private String specificProductUrl;
    private String genericProductUrl;

    FakeStoreClient(RestTemplateBuilder restTemplateBuilder,
                    @Value("${fakestore.api.url}") String fakeStoreUrl,
                    @Value("${fakestore.api.path.products}") String pathForProducts) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.specificProductUrl = fakeStoreUrl+pathForProducts+"/{id}";
        this.genericProductUrl = fakeStoreUrl+pathForProducts;
    }

    // GenericProductDto is an internal class to show the data as we want.
    /* Replacing GenericProductDto to FakeStoreDto because
     Client class are dealing with 3rd party and 3rd party should know about FakeStoreDto
     GenericProductDto is for our internal use. */

//    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {

        //Below code should have fakeStore Api call/ Integrate the fakeStore Api.
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product with id : "+ id +" doesn't exist.");
        }

        //Adding extra layer in case there is a change in the attribute of an api
        return fakeStoreProductDto;
    }

    public List<FakeStoreProductDto> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(genericProductUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(responseEntity.getBody());
//        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
//            genericProductDtos.add(convertToGenericProductDto(fakeStoreProductDto));
//        }
        return fakeStoreProductDtos;
    }

    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(genericProductUrl,genericProductDto,FakeStoreProductDto.class);

        return responseEntity.getBody();
    }


    public FakeStoreProductDto deleteProductById(Long id) {
        // Below code work if we have to delete the data only.
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        restTemplate.delete(sepecificProductUrl, id);

        // This below code will delete the data and give the data it deleted.
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return responseEntity.getBody();
    }



//    public GenericProductDto updateProductById(GenericProductDto genericProductDto,Long id) {
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.exchange(specificProductUrl,HttpMethod.PUT, genericProductDto, FakeStoreProductDto.class, id);
//
//        return convertToGenericProductDto(responseEntity.getBody());
//    }
}
