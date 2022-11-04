package com.swapp.swapp.model;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

import org.json.JSONObject;

public class RequestThread extends Thread{
    private String author = new String();
    private String title = new String();
    private JSONObject json;

    public RequestThread(String author, String title){
        this.author = author;
        this.title = title;
    }

    public JSONObject getJSON(){
        return json;
    }

    @Override
    public void run(){
        try{
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=search+intitle:"+title+"+inauthor:"+author+"&key=AIzaSyDq6wMUMxnTu5aNWmNn5DakO8EbeMJlMv8")) 
                .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            
            json = new JSONObject(response.body());
        }
        catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }    
}