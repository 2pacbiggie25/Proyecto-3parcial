package com.example.proyecto3parcial;

import android.content.ContentValues;
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
        Restaurantedb.execSQL("create table TipoUsuario (codigo int primary key autoincrement, tipoUsuario boolean)");
        Restaurantedb.execSQL("create table Usuario (codigo int primary key autoincrement,idTipoUsuario int, nombre text, apellido text, correo text, usuario text, password text, foreign key(idTipoUsuario)references tipoUsuario(codigo) )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase Restaurantedb, int oldVersion, int newVersion) {

    }
}
