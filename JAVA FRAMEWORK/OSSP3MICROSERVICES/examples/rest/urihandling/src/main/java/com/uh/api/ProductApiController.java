package com.uh.api;

import com.uh.dto.Error;
import com.uh.dto.ProductDto;
import com.uh.dto.ProductListingDto;
import com.uh.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.SecureRandom;

@RestController
@RequestMapping("/product")
public class ProductApiController {

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ProductListingDto addProduct(@RequestBody ProductDto product) throws IOException {
        ProductListingDto productListingDto = new ProductListingDto();

        productListingDto.setProductNo(new SecureRandom().nextInt(10000));
        productListingDto.setProductName(product.getProductName());
        productListingDto.setCategory("General");

        return productListingDto;
    }

    // complex responses
    @GetMapping(value = "/{productCode}/price")
    public ResponseEntity<?> getProducePrice(@PathVariable("productCode") String productCode) {
        if(productCode.equals("p0001")) {
            throw new ProductNotFoundException("product code does not exist");
//            Error error = new Error();
//            error.setErrorCode("a0001");
//            error.setErrorMessage("Product doesnt exist");
//
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        return ResponseEntity.ok().header("app-code", "a00029")
                .body("939.3");
    }
}



















