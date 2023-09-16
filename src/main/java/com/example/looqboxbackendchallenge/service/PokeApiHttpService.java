package com.example.looqboxbackendchallenge.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Service
public class PokeApiHttpService implements Serializable {
    private final OkHttpClient httpClient;

    public PokeApiHttpService() {
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();
    }


    public Response requestAllPokemons() throws IOException {
        Request request = new Request.Builder()
                .url("https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0")
                .get()
                .addHeader("Accept", "application/json")
                .addHeader("Content-type", "application/json")
                .build();

        return httpClient.newCall(request).execute();
    }
}
