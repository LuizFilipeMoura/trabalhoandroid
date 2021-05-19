package com.example.emprego;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView txtNome = findViewById(R.id.txtNome);
        Bundle args=getIntent().getExtras();
        String nome=args.getString("ch_usuario");
        txtNome.setText("Bem vindo" + nome);
    }
}