package com.rc.api;

import com.rc.dto.Product;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.ws.rs.*;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.*;

import java.util.HashMap;
import java.util.Map;

@Path("/product")
@OpenAPIDefinition(info = @Info(title = "ProductApiService", description = "product info"))
public class ProductApiService {
    private Map<String, Product> productDbMap;

    public ProductApiService() {
        productDbMap = new HashMap<>();
        Product product = Product.of().productNo("P0001").productName("32 inch Led Television")
                .description("Full HD 32 Inch Smart Led Television")
                .manufacturer("LG").price(32000).build();
        productDbMap.put(product.getProductNo(), product);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(method = "updateProduct")
    public void updateProduct(Product product) {
        if(productDbMap.containsKey(product.getProductNo())) {
            productDbMap.put(product.getProductNo(), product);
        }else {
            throw new NotFoundException("Product Not Found to Update");
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{productNo}/details")
    public Response getProductDetails(@PathParam("productNo") String productNo, @Context Request request) {
        Product product = null;
        Response response = null;
        EntityTag entityTag = null;
        CacheControl cacheControl = null;
        Response.ResponseBuilder responseBuilder = null;

        if (productDbMap.containsKey(productNo) == false) {
            throw new NotFoundException("Product not found");
        }
        System.out.println("fetching the product info from the database...");

        product = productDbMap.get(productNo);
        entityTag = new EntityTag(String.valueOf(product.hashCode()));

        responseBuilder = request.evaluatePreconditions(entityTag);
        if (responseBuilder != null) {
            return responseBuilder.build();
        }

        responseBuilder = Response.ok(Entity.json(product));
        responseBuilder = responseBuilder.tag(entityTag);
        cacheControl = new CacheControl();
        cacheControl.setMaxAge(10000);
        cacheControl.setMustRevalidate(false);
        responseBuilder = responseBuilder.cacheControl(cacheControl);
        response = responseBuilder.build();

        return response;
    }
}
