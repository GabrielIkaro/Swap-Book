package com.swapp.swapp.GoogleBooksAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.databind.JsonNode;

import io.micrometer.core.ipc.http.HttpSender.Response;
import reactor.core.publisher.Mono;

public class GeolocationAPI {

    private static final Object key = "AIzaSyBTpOsSkhnSEfNrAG3k_CH46HYTgIZ0g94";
    
    public JsonNode getBookDetails(String zip) {
        // Query the book database by ISBN code.

        Mono<JsonNode> s = WebClient.create("https://maps.googleapis.com")
        .get()
        .uri("/maps/api/geocode/json?address=" + zip + ",BR&key=" + key)
        .retrieve()
        .bodyToMono(JsonNode.class);

        
        JsonNode  metaNode = s.block();
        System.out.println(metaNode);
        return metaNode;
   
      }
}
