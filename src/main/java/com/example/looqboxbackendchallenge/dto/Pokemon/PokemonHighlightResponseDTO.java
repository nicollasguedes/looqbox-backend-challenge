package com.example.looqboxbackendchallenge.dto.Pokemon;

import com.example.looqboxbackendchallenge.entity.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonHighlightResponseDTO {
    List<Pokemon> results = new ArrayList<Pokemon>();

    public PokemonHighlightResponseDTO() {
    }

    public static PokemonHighlightResponseDTO convertToDTO(List<Pokemon> pokemonList) {
        PokemonHighlightResponseDTO responseDTO = new PokemonHighlightResponseDTO();

        responseDTO.results.addAll(pokemonList);
        return responseDTO;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
