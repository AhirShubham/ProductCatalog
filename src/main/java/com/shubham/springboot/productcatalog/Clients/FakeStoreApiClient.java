package com.shubham.springboot.productcatalog.Clients;

import com.shubham.springboot.productcatalog.dtos.FakeStoreProductDto;
import com.shubham.springboot.productcatalog.models.Category;
import com.shubham.springboot.productcatalog.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreApiClient {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductDto getProductById(Long id){

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity("https://fakestoreapi.com/products/{id}",HttpMethod.GET,null, FakeStoreProductDto.class, id);

        return fakeStoreProductDtoResponseEntity.getBody();
    }

    public List<FakeStoreProductDto> getProducts(){

        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoResponseEntity = restTemplateBuilder.build().getForEntity("https://fakestoreapi.com/products",FakeStoreProductDto[].class);

        return Arrays.asList(fakeStoreProductDtoResponseEntity.getBody());


    }

    public FakeStoreProductDto replaceProduct(Long id, FakeStoreProductDto fakeStoreProductDto){

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponse=requestForEntity("https://fakestoreapi.com/products/{id}",HttpMethod.PUT,fakeStoreProductDto,FakeStoreProductDto.class,id);

        return fakeStoreProductDtoResponse.getBody();

    }


    private <T> ResponseEntity<T> requestForEntity(String url, HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }



}
