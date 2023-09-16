package com.example.looqboxbackendchallenge.entity;


import java.util.Objects;

public class Pokemon {

    String name;
    String highlight;

    public Pokemon(String name, String query) {
        this.name = name;

        if (Objects.equals(query, "")) {
            this.highlight = "<pre>" + name + "</pre>";
        } else {
            this.highlight = name.replace(query, String.format("<pre>%s</pre>", query));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }
}
