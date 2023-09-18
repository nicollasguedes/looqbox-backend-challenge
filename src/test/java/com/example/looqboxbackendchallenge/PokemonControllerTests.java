package com.example.looqboxbackendchallenge;

import com.example.looqboxbackendchallenge.dto.Pokemon.PokemonHighlightResponseDTO;
import com.example.looqboxbackendchallenge.dto.Pokemon.PokemonResponseDTO;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@AutoConfigureMockMvc
public class PokemonControllerTests {

    /* Field injection is not recommended in production code,
    because it makes reasoning messy (what was injected where and why). But test contexts
    (and especially those like this one) are simple, so there the pitfall of hard
    reasoning is not there.*/
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;
    private static final MediaType APLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON;


    @Test
    public void getPokemonHttpRequest200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/pokemon/search?query=pi&sortType=ALPHABETICAL_ASC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APLICATION_JSON_UTF8));
    }

    @Test
    public void getPokemonHttpRequest200AllPokemon() throws Exception {
        var result = mockMvc.perform(MockMvcRequestBuilders.get(
                "/pokemon/search?query=&sortType=ALPHABETICAL_ASC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APLICATION_JSON_UTF8));

        String body = result.andReturn().getResponse().getContentAsString();
        PokemonResponseDTO response = gson.fromJson(body, PokemonResponseDTO.class);
        assertEquals(1281, response.getResults().size());
    }

    @Test
    public void getPokemonHighlightHttpRequest200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/pokemon/search-highlight?query=pi&sortType=ALPHABETICAL_ASC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APLICATION_JSON_UTF8));
    }

    @Test
    public void getPokemonHighlightHttpRequest200AllPokemon() throws Exception {
        var result = mockMvc.perform(MockMvcRequestBuilders.get(
                "/pokemon/search-highlight?query=&sortType=ALPHABETICAL_ASC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APLICATION_JSON_UTF8));

        String body = result.andReturn().getResponse().getContentAsString();

        PokemonHighlightResponseDTO response = gson.fromJson(body, PokemonHighlightResponseDTO.class);

        assertEquals(1281, response.getResults().size());
    }

}

