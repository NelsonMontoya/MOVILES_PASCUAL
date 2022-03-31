package com.movilespascual.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListaElementos> elementos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void  init(){
        elementos = new ArrayList<>();
        elementos.add(new ListaElementos("#7B1FA2","Pedro","Ciudad de México","Activo"));
        elementos.add(new ListaElementos("#D500F9","Julio","Bogotá","Activo"));
        elementos.add(new ListaElementos("#880E4F","Juan","Cali","Cancelado"));
        elementos.add(new ListaElementos("#F9A825","Jessica","Paris","Inactivo"));
        elementos.add(new ListaElementos("#689F38","Amalia","Ciudad de México","Activo"));
        elementos.add(new ListaElementos("#0091EA","Katie De Felice","New York","Activo"));
        elementos.add(new ListaElementos("#F06292","Evelin","New York","Inactiva"));
        elementos.add(new ListaElementos("#00E5FF","Jean Paul","Marsella","Activo"));

        ListAdapter listAdapter = new ListAdapter(elementos,this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

}