package com.tutorial.sandbox.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.sandbox.Config.YoConfig;
import com.tutorial.sandbox.DTO.Response.YoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class YoService {

    @Autowired
    private YoConfig yoCfg;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private ObjectMapper objectMapper;

    private RestTemplate restTemplate;
    public YoResponse getForecast(String numer){
        restTemplate = restTemplateBuilder.build();
        URI url = new UriTemplate(yoCfg.getYo().getLink()).expand(numer,"metric","pl");
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        return responseTranslator(response);
    }

    private YoResponse responseTranslator(ResponseEntity<String> response){
        try{
            JsonNode root = objectMapper.readTree(response.getBody());
            return new YoResponse(
                    root.path("joke").asText());
        }catch (Exception e){
            System.out.println("error");
            return null;
        }
    }

}
