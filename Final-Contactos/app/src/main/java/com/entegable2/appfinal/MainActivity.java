package com.entegable2.appfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import com.entegable2.appfinal.bd.TransaccionesContactos;
import com.entegable2.appfinal.entidades.Contactos;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    RecyclerView listaContactos;
    ArrayList<Contactos> listaArrayContactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaContactos = findViewById((R.id.lista_contactos));
        listaContactos.setLayoutManager((new LinearLayoutManager(this)));

        TransaccionesContactos dbContactos = new TransaccionesContactos(MainActivity.this);
        dbContactos.datainicial();

        listaArrayContactos = new ArrayList<>();

        ListAdapter adapter = new ListAdapter(dbContactos.consultarContactos());

        listaContactos.setAdapter(adapter);
    }


}