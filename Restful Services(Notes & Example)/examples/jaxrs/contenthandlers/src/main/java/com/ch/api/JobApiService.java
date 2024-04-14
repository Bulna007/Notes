package com.ch.api;

import jakarta.json.*;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;

import javax.print.attribute.standard.Media;
import java.io.*;
import java.security.SecureRandom;

@Path("/job")
public class JobApiService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ins")
    public String newJobThroughInputStream(InputStream ins) {
        int c = 0;
        String keyName = null;
        String jobTitle = null;
        JsonParser.Event event = null;
        StringWriter stringWriter = null;

        // {jobNo=randomNo, title: Java Developer}
        JsonParser jsonParser = Json.createParser(ins);
        while (jsonParser.hasNext()) {
            event = jsonParser.next();
            if (event == JsonParser.Event.KEY_NAME) {
                keyName = jsonParser.getString();
                if (keyName.equals("title")) {
                    jsonParser.next();
                    jobTitle = jsonParser.getString();
                    break;
                }
            }
        }
        int jobNo = new SecureRandom().nextInt(9999999);
        stringWriter = new StringWriter();
        JsonGenerator jsonGenerator = Json.createGenerator(stringWriter);
        jsonGenerator.writeStartObject();
        jsonGenerator.write("jobNo", jobNo);
        jsonGenerator.write("title", jobTitle);
        jsonGenerator.write("status", "posted");
        jsonGenerator.writeEnd();
        jsonGenerator.close();

        return stringWriter.toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/rdr")
    public byte[] newJobThroughReader(Reader reader) {
        byte[] resp = null;
        String jobTitle = null;
        JsonReader jsonReader = null;
        JsonWriter jsonWriter = null;
        ByteArrayOutputStream bos = null;

        jsonReader = Json.createReader(reader);
        JsonObject jsonObject = jsonReader.readObject();
        jobTitle = jsonObject.getString("title");

        int jobNo = new SecureRandom().nextInt(99999);

        bos = new ByteArrayOutputStream();
        jsonWriter = Json.createWriter(bos);
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        jsonObjectBuilder.add("jobNo", jobNo);
        jsonObjectBuilder.add("title", jobTitle);
        jsonObjectBuilder.add("status", "posted");

        JsonObject respObject = jsonObjectBuilder.build();
        jsonWriter.writeObject(respObject);

        resp = bos.toByteArray();

        return resp;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/file")
    public String attachResume(File inFile) throws IOException {
        int c = 0;
        StringBuilder builder = new StringBuilder();
        String contents = null;
        BufferedInputStream bis = null;

        bis = new BufferedInputStream(new FileInputStream(inFile));
        while((c = bis.read()) != -1) {
            builder.append((char)c);
        }
        contents = builder.toString();

        return contents;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/bytes")
    public byte[] newJobInBytes(byte[] jobBytes) {
        byte[] resp = null;
        String jobTitle = null;
        String keyName = null;
        JsonParser.Event event = null;
        JsonParser jsonParser = null;
        ByteArrayOutputStream bos = null;

        jsonParser = Json.createParser(new ByteArrayInputStream(jobBytes));
        while(jsonParser.hasNext()) {
            event = jsonParser.next();
            if(event == JsonParser.Event.KEY_NAME) {
                keyName = jsonParser.getString();
                if(keyName.equals("title")) {
                    jsonParser.next();
                    jobTitle = jsonParser.getString();
                    break;
                }
            }
        }
        int jobNo = new SecureRandom().nextInt(99999);
        bos = new ByteArrayOutputStream();
        JsonGenerator jsonGenerator = Json.createGenerator(bos);
        jsonGenerator.writeStartObject();
        jsonGenerator.write("jobNo", jobNo);
        jsonGenerator.write("title", jobTitle);
        jsonGenerator.writeEnd();
        jsonGenerator.close();

        resp = bos.toByteArray();

        return resp;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/str")
    public String newJobWithString(String jobData) {
        return jobData;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/form")
    public String newJobWithFormData(MultivaluedMap<String, String> jobForm) {
        StringWriter writer = null;
        String jobTitle = jobForm.getFirst("title");
        int jobNo = new SecureRandom().nextInt(9999);
        writer = new StringWriter();

        JsonGenerator jsonGenerator = Json.createGenerator(writer);
        jsonGenerator.writeStartObject();
        jsonGenerator.write("jobNo", jobNo);
        jsonGenerator.write("title", jobTitle);

        jsonGenerator.writeStartArray("skills");
        jobForm.get("skills").forEach((skill)-> {
            jsonGenerator.write(skill);
        });
        jsonGenerator.writeEnd();

        jsonGenerator.writeEnd();
        jsonGenerator.close();
        return writer.toString();
    }

}


























