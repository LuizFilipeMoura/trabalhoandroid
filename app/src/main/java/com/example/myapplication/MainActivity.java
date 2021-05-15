package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnProximo;
    private EditText nomeAluno;
    private EditText disciplina;
    private EditText curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnProximo = findViewById(R.id.button_first);
        nomeAluno  = findViewById(R.id.nomeAluno);
        disciplina = findViewById(R.id.disciplinaAluno);
        curso = findViewById(R.id.cursoAluno);

        setContentView(R.layout.activity_main);


        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, SegundaAtividade.class);

                String nome = nomeAluno.getText().toString();
                String disc = disciplina.getText().toString();
                String curs = curso.getText().toString();
                Bundle param = new Bundle();
                param.putString("nome", nome);
                param.putString("disc", disc);
                param.putString("curs", curs);
                it.putExtras(param);
                startActivity(it);

            }
        });
    }

}