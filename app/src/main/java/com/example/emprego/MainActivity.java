package com.example.emprego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final DBHelper helper = new DBHelper(this);
    private EditText edtUsuario;
    private EditText edtSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario=findViewById(R.id.edtUsuario);
        edtSenha=findViewById(R.id.edtSenha);
    }
    public void conectar(View view) {
        helper.listarPessoas();
        String usr = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();
        String pass=helper.buscarSenha(usr);
        if(senha.equals(pass)){
            Intent it=new Intent(this, Activity2.class);
            it.putExtra("ch_usuario",usr);
            startActivity(it);
        }else{
            Toast toast=Toast.makeText(MainActivity.this,"Usuário ou senha não encontrado",
                    Toast.LENGTH_LONG);
            toast.show();
        }
    }
    public void cadastrar(View view) {
        Intent it=new Intent(this, CadastroPessoa.class);
        startActivity(it);
    }
}