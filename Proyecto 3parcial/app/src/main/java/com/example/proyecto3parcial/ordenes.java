package com.example.proyecto3parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ordenes extends AppCompatActivity {

    private EditText nombre, ob_codigo, precio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenes);

        nombre = (EditText) findViewById(R.id.txt_Nombre);
        ob_codigo = (EditText) findViewById(R.id.txt_id);
        precio = (EditText) findViewById(R.id.txt_precioPlatillo);

    }
     public  void Buscar(View view){

        BaseDeDatos admin = new BaseDeDatos(this ,"RestauranteApp",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = ob_codigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery("select nombre,precio from Platillo where codigo ="+ codigo,null);
            if (fila.moveToFirst()){
                nombre.setText(fila.getString(0));
                precio.setText(fila.getString(1));

                BaseDeDatos.close();

            }else{
                Toast.makeText(this, "El id no existe", Toast.LENGTH_SHORT).show();
            }

        }else{

            Toast.makeText(this, "Ingrese codigo de platillo", Toast.LENGTH_SHORT).show();
        }

     }//cierre meodo buscar

    public void  Eliminar(View view){

        BaseDeDatos admin = new BaseDeDatos(this ,"RestauranteApp",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = ob_codigo.getText().toString();

        if(!codigo.isEmpty()){

            int id = BaseDeDatos.delete("Platillo" ,"codigo="+ codigo, null);
            BaseDeDatos.close();

            nombre.setText("");//borrar los editext codigo
            precio.setText("");
            ob_codigo.setText("");


            if(id==1){
                Toast.makeText(this, "Platillo eliminado correctamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "El platillo no existe", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debe ingresar el codigo del platillo", Toast.LENGTH_SHORT).show();
        }

    }

}