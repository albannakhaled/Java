package org.example.rest.client;

import java.net.URI;

import org.example.json.model.School;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SchoolClient {
    private final String baseUrl = "http://localhost:9090";

    public School getSchool(){
        School result = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = UriComponentsBuilder
            .fromUriString(baseUrl).path("/school")
            .build().toUri();
    
            ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
            // can use directly School.class instead of String.class
            // ResponseEntity<School> response = restTemplate.getForEntity(uri,School.class);
    
            if(response.getStatusCode().is2xxSuccessful()){
                // use directly School.class instead of String.class
                // result = response.getBody();
                
                // Parse the JSON response use ObjectMapper
                ObjectMapper objectMapper = new ObjectMapper();
                result = objectMapper.readValue(response.getBody(), School.class);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
