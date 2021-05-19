package com.example.emprego;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroPessoa extends AppCompatActivity {
    private final DBHelper helper = new DBHelper(this);
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtCpf;
    private EditText edtTelefone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoa);
        edtNome=findViewById(R.id.edtDescricao);
        edtEmail=findViewById(R.id.edtHoras);
        edtCpf = findViewById(R.id.edtCpf);
        edtTelefone=findViewById(R.id.edtValor);
    }
    public void cadastrar(View view) {

        Pessoa p = new Pessoa();
        p.setNome(edtNome.getText().toString());
        p.setEmail(edtEmail.getText().toString());
        p.setCpf(edtCpf.getText().toString());
        p.setTelefone(edtTelefone.getText().toString());
        helper.inserirPessoa(p);
        Toast toast=Toast.makeText(CadastroPessoa.this,
                "Cadastro realizado com sucesso!",Toast.LENGTH_SHORT);
        toast.show();
        limpar();

    }

    private void limpar() {
        edtNome.setText("");
        edtEmail.setText("");
        edtCpf.setText("");
        edtTelefone.setText("");
    }

    public void cancelar(View view) {
        finish();
    }
}