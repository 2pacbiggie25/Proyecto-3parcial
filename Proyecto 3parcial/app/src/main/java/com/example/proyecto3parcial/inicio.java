package com.example.proyecto3parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void ordenar(View view) {

        Intent botonOrdenar = new Intent(this, CrearOrden.class);

        startActivity(botonOrdenar);
    }
    public void verRecomendaciones(View view) {

        Intent botonRecomendacion = new Intent(this, recomendaciones.class);

        startActivity(botonRecomendacion);
    }
    public void irUbi(View view) {

        Intent botonUbi = new Intent(this, ubicacion.class);

        startActivity(botonUbi);
    }
}