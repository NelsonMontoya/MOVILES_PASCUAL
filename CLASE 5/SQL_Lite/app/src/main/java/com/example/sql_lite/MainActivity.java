package com.example.sql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText cedula,nombre, telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cedula =(EditText) findViewById(R.id.cedula);
        nombre =(EditText) findViewById(R.id.nombre);
        telefono =(EditText) findViewById(R.id.telefono);
    }

    public void registrar(View view){
        AdminBD admin = new AdminBD(this,"BaseDatos", null,1);
        //Abrir la base de datos (instanciar la base de datos)
        SQLiteDatabase baseDatos = admin.getWritableDatabase();
        String document = cedula.getText().toString();
        String name = nombre.getText().toString();
        String telephone = telefono.getText().toString();
        if (!document.isEmpty()){
            Cursor fila  = baseDatos.rawQuery("select cedula, nombre, telefono from usuario where cedula ="+document,null);
            if (fila.moveToFirst()){
                String idPersona = fila.getString(0);
                if (!idPersona.isEmpty()){
                    Toast.makeText(this, "El registro ya existe", Toast.LENGTH_SHORT).show();
                }
            }
        }
        else if(!document.isEmpty() && !name.isEmpty() && !telephone.isEmpty()){
            ContentValues registro  = new ContentValues();
            //Almacenar datos
            registro.put("cedula", document);
            registro.put("nombre", name);
            registro.put("telefono", telephone);
            //Insertar la información en la tabla
            baseDatos.insert("usuario",null,registro);
            //Cerrar Base de datos
            baseDatos.close();
            //Limpiar campos
            cedula.setText("");
            nombre.setText("");
            telefono.setText("");
            Toast.makeText(this,"Registro Almacenado", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Por favor ingresar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public  void consultar(View view){
        AdminBD admin = new AdminBD(this,"BaseDatos",null,1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();
        String document = cedula.getText().toString();
        //String name = nombre.getText().toString();
        //String telephone = telefono.getText().toString();

        if(!document.isEmpty()){
            //Cargar la información que vamos a buscar en la variable fila de tipo Cursor
            Cursor fila  = BasedeDatos.rawQuery("select nombre, telefono from usuario where cedula ="+document,null);
            if (fila.moveToFirst()){
                //Asignar los datos de consulta
                nombre.setText(fila.getString(0));
                telefono.setText(fila.getString(1));
                //Cerrar la base de datos
                BasedeDatos.close();
                Toast.makeText(this, "Datos consultados correctamente", Toast.LENGTH_SHORT).show();

            // Si no se econtraron registros
            }else{
                Toast.makeText(this, "No se encontró el usuario", Toast.LENGTH_SHORT).show();
            }
        //Si el campo cédula está vacío
        }else{
            Toast.makeText(this, "Ingrese un documento de consulta", Toast.LENGTH_SHORT).show();
        }
    }
}