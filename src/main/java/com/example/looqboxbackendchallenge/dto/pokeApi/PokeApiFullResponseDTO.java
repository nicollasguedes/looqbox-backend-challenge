package com.example.looqboxbackendchallenge.dto.pokeApi;

import java.util.List;

public class PokeApiFullResponseDTO {
    Integer count;
    String next;
    String previous;
    List<PokeApiResultsResponseDTO> results;

    public PokeApiFullResponseDTO(Integer count, String next, String previous, List<PokeApiResultsResponseDTO> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<PokeApiResultsResponseDTO> getResults() {
        return results;
    }

    public void setResults(List<PokeApiResultsResponseDTO> results) {
        this.results = results;
    }
}
