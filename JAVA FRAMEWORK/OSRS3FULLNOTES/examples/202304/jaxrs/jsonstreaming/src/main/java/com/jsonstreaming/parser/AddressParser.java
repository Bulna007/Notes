package com.jsonstreaming.parser;

import jakarta.json.Json;
import jakarta.json.stream.JsonParser;

public class AddressParser {
    public static void main(String[] args) {
        JsonParser jsonParser = Json.createParser(AddressParser.class.getClassLoader()
                .getResourceAsStream("address.json"));
        String keyName = null;
        String city = null;
        while (jsonParser.hasNext()) {
            JsonParser.Event event = jsonParser.next();
            if (event == JsonParser.Event.KEY_NAME) {
                keyName = jsonParser.getString();
                if (keyName.equals("city")) {
                    jsonParser.next();
                    city = jsonParser.getString();
                    break;
                }
            }
        }

        System.out.println("city : " + city);
    }
}
