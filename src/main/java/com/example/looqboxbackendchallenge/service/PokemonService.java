package com.example.looqboxbackendchallenge.service;

import com.example.looqboxbackendchallenge.dto.pokeApi.PokeApiFullResponseDTO;
import com.example.looqboxbackendchallenge.dto.pokeApi.PokeApiResultsResponseDTO;
import com.example.looqboxbackendchallenge.entity.Pokemon;
import com.example.looqboxbackendchallenge.utils.PokemonSorter;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    private final PokeApiHttpService pokeApiHttpService;
    private final ObjectMapper objectMapper;
    private List<PokeApiResultsResponseDTO> pokemonResultList;

    public PokemonService(PokeApiHttpService pokeApiHttpService, ObjectMapper objectMapper) {
        this.pokeApiHttpService = pokeApiHttpService;
        this.objectMapper = objectMapper;
    }


    @PostConstruct
    public void requestAllPokemons() throws IOException {
        Response response = pokeApiHttpService.requestAllPokemons();
        PokeApiFullResponseDTO pokeApiFullResponseDTO = objectMapper.
                readValue(response.body().string(), PokeApiFullResponseDTO.class);

        pokemonResultList = pokeApiFullResponseDTO.getResults();
        System.out.println("Iniciando Listagem");
        System.out.println(pokemonResultList.size());
    }

    public List<PokeApiResultsResponseDTO> getPokemonResultList() {
        return pokemonResultList;
    }

    public List<Pokemon> getPokemon(String query, int sortType) {
        List<Pokemon> pokemonList = new ArrayList<>();
        for (PokeApiResultsResponseDTO pokeApiResult : pokemonResultList) {
            if (pokeApiResult.getName().contains(query)) {
                pokemonList.add(new Pokemon(pokeApiResult.getName(), query));
            }
        }
        return new PokemonSorter(pokemonList, sortType).getPokemonList();
    }

    public List<Pokemon> getPokemonHighlight(String query, int sortType, boolean ascending) {
        List<Pokemon> pokemonList = new ArrayList<>();
        for (PokeApiResultsResponseDTO pokeApiResult : pokemonResultList) {
            if (pokeApiResult.getName().contains(query)) {
                pokemonList.add(new Pokemon(pokeApiResult.getName(), query));
            }
        }
        return new PokemonSorter(pokemonList, sortType).getPokemonList();
    }
}

