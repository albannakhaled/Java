package org.example.rest.client;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PhoneRestClient {
    private final String url = "https://api.restful-api.dev/objects?id=3&id=5&id=10";

    public String getPhone(){
        String result = "";
        try {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = UriComponentsBuilder
            .fromUriString(url)
            .build().toUri();
    
            ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
    
            if(response.getStatusCode().is2xxSuccessful()){
                result = response.getBody();
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }   
        return result;
    }    
}
