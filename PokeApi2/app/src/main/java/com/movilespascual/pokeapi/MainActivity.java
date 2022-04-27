package com.movilespascual.pokeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.movilespascual.pokeapi.modelos.Pokemon;
import com.movilespascual.pokeapi.modelos.pokemonResponse;
import com.movilespascual.pokeapi.paquete.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private static final String BASEURL ="https://pokeapi.co/api/v2/";
    private static final String TAG ="POKEMON_RESPONSE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new  Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatosPokemon();
    }

    private void obtenerDatosPokemon() {
        APIService servicio = retrofit.create(APIService.class);
        Call<pokemonResponse> respuesta = servicio.obtenerListaPokemon();

        respuesta.enqueue(new Callback<pokemonResponse>() {
            @Override
            public void onResponse(Call<pokemonResponse> call, Response<pokemonResponse> response) {
                if (response.isSuccessful()){
                    //Se obtiene la respuesta de la API
                    pokemonResponse respuestaApi = response.body();
                    //se obtienen los datos en un arrayList tipo Pokemon
                    ArrayList <Pokemon> listPokemon = respuestaApi.getResults();
                    // se muestran en consola todos los datos recibidos de la   API en el campo results
                    for (int i = 0; i < listPokemon.size(); i++) {
                        Pokemon poke = listPokemon.get(i);
                        Log.i(TAG,"Pokemon: "+ poke.getName());
                    }
                }else{
                    Log.e(TAG,"Error" +response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<pokemonResponse> call, Throwable t) {
                Log.e(TAG,"onFailure" + t.getMessage());
            }
        });
    }
}