package com.example.proyecto3parcial;

/*import android.content.ContentValues;*/
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BaseDeDatos extends SQLiteOpenHelper
{

    public BaseDeDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase Restaurantedb) {
        Restaurantedb.execSQL("create table Usuario (codigo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombre text, apellido text, correo text, usuario text, password text,admin int)");
        Restaurantedb.execSQL("create table Platillo(codigo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombre text, descripcion text, precio int)");
        Restaurantedb.execSQL("create table Recomendacion(codigo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, descripcion text)");
        Restaurantedb.execSQL("create table Ordenes(codigo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombre text, codigor int, codigop int)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase Restaurantedb, int oldVersion, int newVersion) {

    }
    public ArrayList llenarordenes(){
        ArrayList<String>lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q =  "SELECT * FROM Ordenes";
        Cursor registros = database.rawQuery(q,null);
        if(registros.moveToFirst()){
            do{
                lista.add(registros.getString(0));
            }while (registros.moveToNext());
        }
        return lista;
    }
}
