package com.srt.service;

import com.srt.dto.ProductDto;
import com.srt.dto.ProductListingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    private final String BASE_URI = "http://localhost:8080/urihandling/product";

    @Autowired
    private RestTemplate restTemplate;

    public String getProductPrice(String productCode) {
        String price = null;
        ResponseEntity<String> responseEntity = null;
        Map<String, Object> pathVariables = null;

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(BASE_URI).path("/{productCode}/price");
        pathVariables = new HashMap<>();
        pathVariables.put("productCode", productCode);
        String requestURI = uriComponentsBuilder.uriVariables(pathVariables).toUriString();

        responseEntity = restTemplate.getForEntity(requestURI, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            price = responseEntity.getBody();
        }

        return price;
    }

    public ProductListingDto addProduct(ProductDto productDto) {
        ResponseEntity<ProductListingDto> responseEntity = null;
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(BASE_URI);
        HttpEntity<ProductDto> entity = new HttpEntity<>(productDto);

        responseEntity = restTemplate.postForEntity(uriComponentsBuilder.toUriString(), entity, ProductListingDto.class);
        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        }
        return null;
    }
}
