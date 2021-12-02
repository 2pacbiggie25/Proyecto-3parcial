package com.example.proyecto3parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText ob_nombre, ob_apellido, ob_correo, ob_usuario, ob_password, ob_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ob_nombre = (EditText) findViewById(R.id.txt_Nombre);
        ob_apellido = (EditText) findViewById(R.id.txt_apellido2);
        ob_correo = (EditText) findViewById(R.id.txt_correo);
        ob_usuario = (EditText) findViewById(R.id.txt_usuario);
        ob_password = (EditText) findViewById(R.id.txt_passwordRegistro);
        ob_admin = (EditText) findViewById(R.id.txt_admin);

    }
    public void crearUsuario (View view){

        BaseDeDatos admin = new BaseDeDatos(this,"RestauranteApp",null,1);
        SQLiteDatabase BaseDB = admin.getWritableDatabase();

        String nombre = ob_nombre.getText().toString();
        String apellido = ob_apellido.getText().toString();
        String correo = ob_correo.getText().toString();
        String usuario = ob_usuario.getText().toString();
        String password= ob_password.getText().toString();
        String privilegios= ob_admin.getText().toString();

        if(!nombre.isEmpty() && !apellido.isEmpty() && !correo.isEmpty() && !usuario.isEmpty() && !password.isEmpty() && !privilegios.isEmpty()){


            ContentValues registro = new ContentValues();


            registro.put("nombre", nombre);
            registro.put("apellido", apellido);
            registro.put("correo", correo);
            registro.put("usuario", usuario);
            registro.put("password", password);
            registro.put("admin", privilegios);

            Toast.makeText(this,"Usuarios Registrados",Toast.LENGTH_SHORT).show();
            BaseDB.insert("Usuario",null,registro);
            BaseDB.close();

            ob_nombre.setText("");
            ob_apellido.setText("");
            ob_correo.setText("");
            ob_usuario.setText("");
            ob_password.setText("");
            ob_admin.setText("");

            Intent login = new Intent(this,MainActivity.class);
            startActivity(login);


        }
        else {

            Toast.makeText(this, "Deben llenarse todos los campos", Toast.LENGTH_SHORT).show();

             }
    }
}