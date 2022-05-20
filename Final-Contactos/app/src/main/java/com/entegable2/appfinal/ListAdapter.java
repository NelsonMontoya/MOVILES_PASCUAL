package com.entegable2.appfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.entegable2.appfinal.entidades.Contactos;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ContactoViewHolder> {

    ArrayList<Contactos> listaContactos;

    public ListAdapter(ArrayList<Contactos> listaContactos){
        this.listaContactos = listaContactos;
    }


    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int i) {
        holder.viewNombre.setText(listaContactos.get(i).getNombre());
        holder.viewCiudad.setText(listaContactos.get(i).getCiudad());
        holder.viewProfesion.setText(listaContactos.get(i).getProfesion());
        holder.viewTelefono.setText(listaContactos.get(i).getTelefono());
        holder.viewCorreo.setText(listaContactos.get(i).getEmail());
    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewCiudad, viewProfesion, viewTelefono, viewCorreo;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById((R.id.nombreContacto));
            viewCiudad = itemView.findViewById((R.id.ciudadContacto));
            viewProfesion = itemView.findViewById((R.id.profesionContacto));
            viewTelefono = itemView.findViewById((R.id.telefonoContacto));
            viewCorreo = itemView.findViewById((R.id.emailContacto));
        }
    }
}
