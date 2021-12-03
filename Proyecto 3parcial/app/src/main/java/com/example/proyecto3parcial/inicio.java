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

        Intent botonMenu = new Intent(this, CrearOrden.class);

        startActivity(botonMenu);
    }
    public void verRecomendaciones(View view) {

        Intent botonRecomendacion = new Intent(this, recomendaciones.class);

        startActivity(botonRecomendacion);
    }
}