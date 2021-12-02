package com.example.proyecto3parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usuarioInput;
    private EditText passwordInput;
    private TextView obj_prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioInput = (EditText) findViewById(R.id.usuarioInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        obj_prueba = (TextView) findViewById(R.id.prueba);

    }

    public void irInicio(View view) {

        BaseDeDatos admin = new BaseDeDatos(this,"RestauranteApp",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String usuario = usuarioInput.getText().toString();
        String password = usuarioInput.getText().toString();

        if( !usuario.isEmpty() && !password.isEmpty() ) {
            //Toast.makeText(this,"Pasaron validacion", Toast.LENGTH_SHORT).show();

            //Cursor fila = bd.rawQuery("SELECT nombre,apellido,correo,usuario,password,admin FROM Usuario WHERE usuario ="+usuario+" AND password = " +password, null);
            Cursor fila = bd.rawQuery("select admin from Usuario where usuario ="+usuario, null);

            if(fila.moveToFirst()) {
                obj_prueba.setText( fila.getString(0) );
                bd.close();

                Intent botonInicio = new Intent(this, inicio.class);
                startActivity(botonInicio);


            } else {
                Toast.makeText(this,"no existe el usuario , cree uno", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this,"Ingrese usuario y contraseña", Toast.LENGTH_SHORT).show();

        }


    }

    public void irRegistro(View view) {

        Intent botonRegistro = new Intent(this, Registro.class);

        startActivity(botonRegistro);
    }

}