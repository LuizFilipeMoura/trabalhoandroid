package com.example.emprego;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jonathas.aula01room.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdicionarPessoaFragment extends Fragment {

    Button buttonInserirUsuario;
    EditText edInserirId, edInserirNome, edInserirEmail, edInserirProdutora, edInserirPlataforma, edInserirGenero;

    public AdicionarPessoaFragment() {
        // Required empty public constructor
    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_adicionar_pessoa, container, false);
        buttonInserirUsuario = view.findViewById(R.id.buttonInserir);
        edInserirEmail = view.findViewById(R.id.editTextHoras);
        edInserirId = view.findViewById(R.id.editTextInserirId);
        edInserirNome = view.findViewById(R.id.editTextInserirDescricao);
        edInserirProdutora = view.findViewById(R.id.editTextInserirCPF);
        edInserirPlataforma = view.findViewById(R.id.editTextInserirEmail);
        edInserirGenero = view.findViewById(R.id.editTextInserirTelefone);


        buttonInserirUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userId = Integer.parseInt(edInserirId.getText().toString());
                String userNome = edInserirNome.getText().toString();
                String email = edInserirEmail.getText().toString();
                String produtora = edInserirProdutora.getText().toString();
                String plataforma = edInserirPlataforma.getText().toString();
                String genero = edInserirGenero.getText().toString();


                Pessoa pessoa = new Pessoa();
                pessoa.setEmail(email);
                pessoa.setId(userId);
                pessoa.setNome(userNome);
                pessoa.setProdutora(produtora);
                pessoa.setPlataforma(plataforma);
                pessoa.setGenero(genero);


                MainActivity.myAppDatabase.myDAO().inserirPessoa(pessoa);

                Toast.makeText(getActivity(), "Aluno Inserido com Sucesso!", Toast.LENGTH_LONG).show();
            }
        });

        return view;


    }

}
