package com.example.proyecto3parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irInicio(View view) {

        Intent botonInicio = new Intent(this, inicio.class);

        startActivity(botonInicio);
    }

    public void irRegistro(View view) {

        Intent botonRegistro = new Intent(this, Registro.class);

        startActivity(botonRegistro);
    }

}