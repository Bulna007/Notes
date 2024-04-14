package com.jsonparsing.reader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class PersonReader {
    public static void main(String[] args) {
        JsonReader jsonReader = Json.createReader(PersonReader.class.getClassLoader().getResourceAsStream("person.json"));
        JsonObject personObject = jsonReader.readObject();

        System.out.println("fullname : " + personObject.getString("fullname"));
        System.out.println("age : " + personObject.getInt("age"));

        JsonObject addressObject = personObject.getJsonObject("address");
        System.out.println("city : " + addressObject.getString("city"));

    }
}
