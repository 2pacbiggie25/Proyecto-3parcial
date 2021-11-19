package com.example.proyecto3parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void irPlatillo(View view) {

        Intent botonPlatillo = new Intent(this, platillo.class);

        startActivity(botonPlatillo);

    }

    public void verOrden(View view) {

        Intent botonOrden = new Intent(this, ordenes.class);

        startActivity(botonOrden);
    }
}