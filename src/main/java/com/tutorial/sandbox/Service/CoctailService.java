package com.tutorial.sandbox.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.sandbox.Config.YAMLConfiguration;
import com.tutorial.sandbox.DTO.Response.CoctailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.math.BigDecimal;
import java.net.URI;

@Service
public class CoctailService {

    @Autowired
    private YAMLConfiguration ymlCfg;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private ObjectMapper objectMapper;

    private RestTemplate restTemplate;

    public CoctailResponse getCoctail(String drink){
        restTemplate = restTemplateBuilder.build();
        URI url = new UriTemplate(ymlCfg.getCoctail().getUrl()).expand(ymlCfg.getCoctail().getKey(),drink);
        System.out.println(url.toString());
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        return responseTranslator(response);
    }

    private CoctailResponse responseTranslator(ResponseEntity<String> response){
        try{
            JsonNode root = objectMapper.readTree(response.getBody());
            return new CoctailResponse(
                    root.path("drinks").get(0).path("strDrink").asText(),
                    root.path("drinks").get(0).path("strInstructions").asText()
                    );
        }catch (Exception e){
            System.out.println("JSON spadł z rowerka");
            return null;
        }
    }
}
