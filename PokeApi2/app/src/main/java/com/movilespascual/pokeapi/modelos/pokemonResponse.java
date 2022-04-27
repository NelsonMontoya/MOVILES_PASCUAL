package com.movilespascual.pokeapi.modelos;

import java.util.ArrayList;

public class pokemonResponse {
    // el array debe tener el mismo nombre del resultado json de la API, para el caso, results
    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
