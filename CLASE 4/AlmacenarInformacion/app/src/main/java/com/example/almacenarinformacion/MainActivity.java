package com.example.almacenarinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.usuario);
        //"datos":  archivo donde se va a almacenar la información. Context, es donde estamos y MODE_PRIVATE
        // modo como se abrirá la información (Context es la aplicación)
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        //usuarios: es donde tendremos almacenado el valor del edit text
        /* s1: "" porque en el método OnCreate es cuando inicia la aplicación, es decir, aun no hay datos allí
        * por lo tanto, se debe asignar un valor por defecto.  Para el caso un string vacío
        * */

        usuario.setText(preferences.getString("usuarios",""));
    }

    public void guardarDatos(View view){
        SharedPreferences preferencias = getSharedPreferences("datos",Context.MODE_PRIVATE);
        // Editor: Para editar
        /* Clase Shared preferences.  Editor nos permitirá editar la información que vamos a guardar.
        a traves de preferencias.edit() guradará lo que hemos modificado
        * */
        SharedPreferences.Editor ObjetoEditor = preferencias.edit();
        //Guardamos lo que hay en el editText con id=usuario
        ObjetoEditor.putString("usuarios",usuario.getText().toString());
        // Aquí ya se guarda
        ObjetoEditor.commit();
        //termina la aplicación
        finish();
    }


}