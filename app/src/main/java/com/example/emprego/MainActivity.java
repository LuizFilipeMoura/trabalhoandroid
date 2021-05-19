package com.example.emprego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final DBHelper helper = new DBHelper(this);
    private EditText edtUsuario;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario=findViewById(R.id.edtUsuario);
        listView = (ListView)findViewById(R.id.listView);

        List<String> strings = new ArrayList<>(helper.listarPessoas().size());
        for (Pessoa pessoa : helper.listarPessoas()) {
            strings.add(pessoa.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id)
            {
                helper.removerPessoa(view, String.valueOf(helper.listarPessoas().get(position).getPessoaId()));
//
//                editar(view, helper.listarPessoas().get(position));
//
//                String selectedFromList = (listView.getItemAtPosition(position).toString());
//                Toast toast=Toast.makeText(MainActivity.this, helper.removerPessoa(view, String.valueOf(helper.listarPessoas().get(position).getPessoaId())),
//                        Toast.LENGTH_LONG);
//                toast.show();

            }});
    }



    public void conectar(View view) {
        helper.listarPessoas();
        String usr = edtUsuario.getText().toString();
        String pass=helper.buscarSenha(usr);

    }

    public void cadastrar(View view) {
        Intent it=new Intent(this, CadastroPessoa.class);
        startActivity(it);
    }

    public void editar(View view, Pessoa p) {

        Intent it = new Intent(this, CadastroPessoa.class);
        it.putExtra("pessoa",  p);
        startActivity(it);
    }
}