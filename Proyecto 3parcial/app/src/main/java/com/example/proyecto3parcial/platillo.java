package com.example.proyecto3parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class platillo extends AppCompatActivity {

    private EditText ob_nombre, ob_descripcion, ob_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platillo);

        ob_nombre = (EditText) findViewById(R.id.txt_nombreplato);
        ob_descripcion = (EditText) findViewById(R.id.txt_descripcionPlato);
        ob_precio = (EditText) findViewById(R.id.txt_precioPlato);
    }

    public void crearPlatillo(View view){

        BaseDeDatos admin = new BaseDeDatos(this,"RestauranteApp",null,1);
        SQLiteDatabase BaseDB = admin.getWritableDatabase();

        String nombre = ob_nombre.getText().toString();
        String descripcion = ob_descripcion.getText().toString();
        String precio = ob_precio.getText().toString();

        if(!nombre.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){


            ContentValues registro = new ContentValues();


            registro.put("nombre", nombre);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);


            Toast.makeText(this,"Plato Creado",Toast.LENGTH_SHORT).show();
            BaseDB.insert("Platillo",null,registro);
            BaseDB.close();

            ob_nombre.setText("");
            ob_descripcion.setText("");
            ob_precio.setText("");


        }
        else {

            Toast.makeText(this, "Deben llenarse todos los campos", Toast.LENGTH_SHORT).show();

        }
    }
}
