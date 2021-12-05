package com.example.proyecto3parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CrearOrden extends AppCompatActivity {
    ListView lvo;
    ArrayList<String> listviewOrdenes;
    ArrayAdapter adaptador;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_orden);
            lvo=(ListView)findViewById(R.id.listCrearOrdenes);
            BaseDeDatos db = new BaseDeDatos(getApplicationContext(),"RestauranteApp",null,1);
            listviewOrdenes = db.llenarordenes();
            adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listviewOrdenes);
            lvo.setAdapter(adaptador);
    }
}