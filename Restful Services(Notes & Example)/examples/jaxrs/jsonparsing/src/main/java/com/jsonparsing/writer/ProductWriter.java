package com.jsonparsing.writer;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonWriter;

import java.io.File;
import java.io.FileOutputStream;

public class ProductWriter {
    public static void main(String[] args) {
        JsonWriter jsonWriter = Json.createWriter(System.out);
        JsonObjectBuilder productJsonObjectBuilder = Json.createObjectBuilder();
        productJsonObjectBuilder.add("productCode", 9383);
        productJsonObjectBuilder.add("productName", "LG 75 Class QLED Tv");
        productJsonObjectBuilder.add("quantity", 30);
        productJsonObjectBuilder.add("price", "456000");
        JsonObject productObject = productJsonObjectBuilder.build();

        jsonWriter.writeObject(productObject);
        jsonWriter.close();

    }
}
