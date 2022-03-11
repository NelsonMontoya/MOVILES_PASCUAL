package com.example.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textoUno, textoDos;
    Button boton;
    String TAG = "Boton creado en: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textoUno = findViewById(R.id.textoUnoRecibido);
        textoDos = findViewById(R.id.textoDosRecibido);

        //recibo datos del intent.  recuperando los extras del MainActivity
        //Intent recibidos = getIntent();
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
        //Mostrar los datos
        textoUno.setText(email);
        textoDos.setText(password);
        Log.i("ActividadDos","--onCreate--");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Declarar el boton
        boton = findViewById(R.id.botonAtras);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(regresar);
            }
        });

        Log.i(TAG,"onStart");
        Log.i("ActividadDos", "--onStart--");
    }
}