package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class SegundaAtividade extends AppCompatActivity {
    private TextView nomeAluno;
    private TextView disciplina;
    private TextView curso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_atividade);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent it2 = getIntent();
        Bundle bundle = it2.getExtras();

        nomeAluno = findViewById(R.id.alunoNome);
        disciplina = findViewById(R.id.disciplinaAluno);
        curso = findViewById(R.id.cursoAluno);

        if(bundle != null){
            String nome = bundle.getString("nome");
            String disciplina2 = bundle.getString("disc");
            String curso2 = bundle.getString("curso");
            if(nome != null){
                nomeAluno.setText(nome);
            }
            if(disciplina2 != null){
                disciplina.setText(disciplina2);
            }
            if(curso2 != null){
                curso.setText(curso2);
            }
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}