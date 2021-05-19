package com.example.emprego;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroEmprego extends AppCompatActivity {

    private final DBHelper helper = new DBHelper(this);
    private EditText edtDescricao;
    private EditText edtHoras;
    private EditText edtValor;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_emprego);
        edtDescricao=findViewById(R.id.edtDescricao);
        edtHoras=findViewById(R.id.edtHoras);
        edtValor=findViewById(R.id.edtValor);
    }
    public void cadastrar(View view) {

        Emprego e = new Emprego();
        e.setDescricao(edtDescricao.getText().toString());
        e.setHorasSemana(Integer.parseInt(edtHoras.getText().toString()));
        e.setValor(Float.parseFloat(edtValor.getText().toString()));

        helper.inserirEmprego(e);
        Toast toast=Toast.makeText(CadastroEmprego.this,
                "Cadastro realizado com sucesso!",Toast.LENGTH_SHORT);
        toast.show();
        limpar();

    }

    private void limpar() {
        edtDescricao.setText("");
        edtHoras.setText("");
        edtValor.setText("");
    }

    public void cancelar(View view) {
        finish();
    }
}