package com.entegable2.appfinal.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.entegable2.appfinal.bd.ConexionBD;
import com.entegable2.appfinal.entidades.Contactos;

import java.util.ArrayList;

public class TransaccionesContactos extends ConexionBD {

    Context context;

    public TransaccionesContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public void datainicial(){
        ConexionBD database = new ConexionBD(context);
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor fila = db.rawQuery("select * from Contactos order by id desc", null);
        if(fila.moveToFirst()){
            return;
        }else{
            SQLiteDatabase dbWrite = database.getWritableDatabase();
            ContentValues insertar = new ContentValues();
            insertar.put("name", "Mis datos");
            insertar.put("city", "Medellin");
            insertar.put("profesion", "Desarrollador");
            insertar.put("phone", "3023334455");
            insertar.put("email", "mhenao@gmail.com");
            dbWrite.insert("Contactos",null, insertar);
            dbWrite.close();
        }

    }

    public ArrayList<Contactos> consultarContactos(){
        ConexionBD database = new ConexionBD(context);
        SQLiteDatabase db = database.getReadableDatabase();

        ArrayList<Contactos> listaContactos = new ArrayList<>();
        Contactos contacto;
        Cursor cursorContactos;

        cursorContactos = db.rawQuery("select * from Contactos order by id desc", null);

        if(cursorContactos.moveToFirst()) {
            do{
                contacto = new Contactos();
                contacto.setId(cursorContactos.getInt(0));
                contacto.setNombre(cursorContactos.getString(1));
                contacto.setCiudad(cursorContactos.getString(2));
                contacto.setProfesion(cursorContactos.getString(3));
                contacto.setTelefono(cursorContactos.getString(4));
                contacto.setEmail(cursorContactos.getString(5));
                listaContactos.add((contacto));
            } while (cursorContactos.moveToNext());
        }

        cursorContactos.close();
        return listaContactos;
    }
}
