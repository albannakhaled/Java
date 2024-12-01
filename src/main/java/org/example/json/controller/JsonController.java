package org.example.json.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.json.model.JsonDataDTO;
import org.example.rest.client.PhoneRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

@Controller
public class JsonController {
    @Autowired 
    private PhoneRestClient phoneRestClient;

    @Value("${file.path}")
    private String path;

    @GetMapping("/readAllIds")
    public String displayJson(Model model) throws IOException {
        try {
            // Parse the JSON file
            File jsonFile = new File(path);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonFile);

            // List to store all IdUrl objects (id and url pairs)
            List<JsonDataDTO> idUrlList = new ArrayList<>();

            // Recursively extract IDs and URLs
            extractIdsAndUrls(rootNode, idUrlList);
            model.addAttribute("idUrlList", idUrlList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    private void extractIdsAndUrls(JsonNode node, List<JsonDataDTO> idUrlList) {
        if (node.isObject()) {
            node.fields().forEachRemaining(field -> {
                if ("id".equals(field.getKey())) {
                    String id = field.getValue().asText();
                    JsonNode urlNode = node.get("url");
                    if (urlNode != null) {
                        String url = urlNode.asText();
                        // Add the pair (id, url) to the list
                        idUrlList.add(new JsonDataDTO(id, url));
                    }
                }
                extractIdsAndUrls(field.getValue(), idUrlList); // Recursively extract from nested objects
            });
        } else if (node.isArray()) {
            for (JsonNode arrayElement : node) {
                extractIdsAndUrls(arrayElement, idUrlList); // Recursively extract from array elements
            }
        }
    }

    @GetMapping("/getPhone")
    public ResponseEntity<String> getPhone(){
        String phone = phoneRestClient.getPhone();
        return ResponseEntity.ok(phone);
    }
}

