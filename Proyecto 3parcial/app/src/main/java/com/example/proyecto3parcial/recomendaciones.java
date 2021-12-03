package com.example.proyecto3parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class recomendaciones extends AppCompatActivity {

    private EditText ob_recomendacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendaciones);

        ob_recomendacion = (EditText) findViewById(R.id.txt_Recomendacion);

    }
    public void crearRecomendacion(View view){

        BaseDeDatos admin = new BaseDeDatos(this,"RestauranteApp",null,1);
        SQLiteDatabase BaseDB = admin.getWritableDatabase();

        String recomendacion = ob_recomendacion.getText().toString();


        if(!recomendacion.isEmpty()){


            ContentValues registro = new ContentValues();


            registro.put("descripcion", recomendacion);


            Toast.makeText(this,"Gracias por su recomendacion",Toast.LENGTH_SHORT).show();
            BaseDB.insert("Recomendacion",null,registro);
            BaseDB.close();

            ob_recomendacion.setText("");


        }
        else {

            Toast.makeText(this, "Deben llenarse todos los campos", Toast.LENGTH_SHORT).show();

        }
    }
}