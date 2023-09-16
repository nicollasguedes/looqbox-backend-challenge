package com.example.looqboxbackendchallenge.controller;

import com.example.looqboxbackendchallenge.dto.Pokemon.PokemonHighlightResponseDTO;
import com.example.looqboxbackendchallenge.dto.Pokemon.PokemonResponseDTO;
import com.example.looqboxbackendchallenge.entity.Pokemon;
import com.example.looqboxbackendchallenge.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("search")
    public ResponseEntity<PokemonResponseDTO> searchPokemon(@RequestParam(defaultValue = "") String query,
                                                            @RequestParam(defaultValue = "0") int sortType) {
        List<Pokemon> pokemonList = pokemonService.getPokemon(query.toLowerCase(), sortType);
        return ResponseEntity.status(HttpStatus.OK).body(PokemonResponseDTO.convertToDTO(pokemonList));
    }

    @GetMapping("search-highlight")
    public ResponseEntity<PokemonHighlightResponseDTO> searchPokemonHighlight(@RequestParam(defaultValue = "") String query,
                                                                              @RequestParam(defaultValue = "0") int sortType) {
        List<Pokemon> pokemonList = pokemonService.getPokemon(query.toLowerCase(), sortType);
        return ResponseEntity.status(HttpStatus.OK).body(PokemonHighlightResponseDTO.convertToDTO(pokemonList));
    }
}
