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


    }

   public void irInicio(View view) {

        String usuario = usuarioInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(!usuario.isEmpty()){

            if (usuario.equals("admin") && password.equals("admin")){

                Intent admin = new Intent(this,menu.class);
                startActivity(admin);
                usuarioInput.setText("");
                passwordInput.setText("");

            }
            else if (usuario.equals("cliente") && password.equals("cliente")){

                Intent inicio = new Intent(this,inicio.class);
                startActivity(inicio);
                usuarioInput.setText("");
                passwordInput.setText("");
            }
            else{

                Toast.makeText(this,"Usuario o Contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }

        }
        else {

            Toast.makeText(this,"Ingrese usuario", Toast.LENGTH_SHORT).show();
        }


    }

    public void irRegistro(View view) {

        Intent botonRegistro = new Intent(this, Registro.class);

        startActivity(botonRegistro);
    }



}