package com.swapp.swapp.GoogleBooksAPI;



import org.springframework.web.reactive.function.client.WebClient;


import com.fasterxml.jackson.databind.JsonNode;

import reactor.core.publisher.Mono;

public class LivroRequest {

    public JsonNode getBookDetails(String isbn) {
        // Query the book database by ISBN code.
        

        Mono<JsonNode> s = WebClient.create("https://www.googleapis.com")
                        .get()
                        .uri("/books/v1/volumes?q=" + isbn)
                        .retrieve()
                        .bodyToMono(JsonNode.class);
      

        JsonNode  metaNode = s.block();
        return metaNode;
   
      }
    
}
