package com.movilespascual.pokeapi.paquete;

import com.movilespascual.pokeapi.modelos.pokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("pokemon")
    Call<pokemonResponse> obtenerListaPokemon();
}
