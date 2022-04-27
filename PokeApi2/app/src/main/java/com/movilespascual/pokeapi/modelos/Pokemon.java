package com.movilespascual.pokeapi.modelos;

public class Pokemon {
    //los nombres debe ser iguales a los que se reciben de la API
    private String name, url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
