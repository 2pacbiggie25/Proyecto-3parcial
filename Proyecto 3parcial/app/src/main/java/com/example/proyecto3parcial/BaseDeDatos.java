package com.example.proyecto3parcial;

/*import android.content.ContentValues;*/
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDeDatos extends SQLiteOpenHelper
{

    public BaseDeDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase Restaurantedb) {
        Restaurantedb.execSQL("create table Usuario (codigo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombre text, apellido text, correo text, usuario text, password text,admin int)");
        Restaurantedb.execSQL("create table Platillo(codigo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombre text, descripcion text, precio int)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase Restaurantedb, int oldVersion, int newVersion) {

    }
}
