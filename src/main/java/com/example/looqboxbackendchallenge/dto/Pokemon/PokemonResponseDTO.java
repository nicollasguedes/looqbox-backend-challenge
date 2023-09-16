package com.example.looqboxbackendchallenge.dto.Pokemon;

import com.example.looqboxbackendchallenge.entity.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonResponseDTO {
    List<String> results = new ArrayList<>();

    public PokemonResponseDTO() {
    }

    public static PokemonResponseDTO convertToDTO(List<Pokemon> pokemonList) {
        PokemonResponseDTO responseDTO = new PokemonResponseDTO();

        for (Pokemon pokemon : pokemonList) {
            responseDTO.results.add(pokemon.getName());
        }
        return responseDTO;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
}
