package com.srt;

import com.srt.dto.ProductDto;
import com.srt.dto.ProductListingDto;
import com.srt.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SRTApplication {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SRTApplication.class, args);
        ProductService productService = applicationContext.getBean("productService", ProductService.class);

//        String price = productService.getProductPrice("PC02932");
//        System.out.println("product price : " + price);
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Refrigerator");
        productDto.setManufacturer("Samsung");
        productDto.setPrice(939.3);

        ProductListingDto productListingDto = productService.addProduct(productDto);
        System.out.println(productListingDto);

    }
}
