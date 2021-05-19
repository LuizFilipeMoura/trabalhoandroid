package com.example.emprego;


import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jonathas.aula01room.R;

public class MainActivity extends AppCompatActivity {


    public static FragmentManager fragmentManager;
    public static DataBase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(),
                DataBase.class, "userdb").fallbackToDestructiveMigration().allowMainThreadQueries().build();


        fragmentManager.beginTransaction().
                add(R.id.frameConteiner, new homeFragment()).
                commit();

    }
}
