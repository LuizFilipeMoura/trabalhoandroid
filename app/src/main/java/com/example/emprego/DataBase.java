package com.example.emprego;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Pessoa.class, Emprego.class}, version = 2)
public abstract class DataBase extends RoomDatabase {

    public abstract DAO myDAO();

}
