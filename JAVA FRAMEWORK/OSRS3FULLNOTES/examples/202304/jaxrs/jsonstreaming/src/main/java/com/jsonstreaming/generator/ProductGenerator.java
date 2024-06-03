package com.jsonstreaming.generator;

import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;

public class ProductGenerator {
    public static void main(String[] args) {
        JsonGenerator jsonGenerator = Json.createGenerator(System.out);
        jsonGenerator.writeStartObject();
        jsonGenerator.write("productNo", 938);
        jsonGenerator.write("productName", "LG 5.5 kg Front Load Washing Machine");
        jsonGenerator.write("manufacturer", "LG");
        jsonGenerator.write("price", 32456);
        jsonGenerator.writeEnd();
        jsonGenerator.close();
    }
}
