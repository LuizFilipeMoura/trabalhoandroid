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
public class AtualizarPessoaFragment extends Fragment {

    Button btAtualiza;
    EditText edAtId, edAtualizaNome, edAtualizaEmail, edAtualizaProdutora, edAtualizaPlataforma, edAtualizaGenero, edAtualizaDistribuidora;


    public AtualizarPessoaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_atualizar_emprego, container, false);

        btAtualiza = view.findViewById(R.id.buttonAtualizaPessoa);
        edAtId = view.findViewById(R.id.editTextId);
        edAtualizaEmail = view.findViewById(R.id.editTextAtualizaHoras);
        edAtualizaNome = view.findViewById(R.id.editTextAtualizaNome);
        edAtualizaProdutora = view.findViewById(R.id.editTextAtualizaCPF);
        edAtualizaPlataforma = view.findViewById(R.id.editTextAtualizaEmail);
        edAtualizaGenero = view.findViewById(R.id.editTextAtualizaTelefone);

        btAtualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userId = Integer.parseInt(edAtId.getText().toString());
                String userNome = edAtualizaNome.getText().toString();
                String email = edAtualizaEmail.getText().toString();
                String produtora = edAtualizaProdutora.getText().toString();
                String plataforma = edAtualizaPlataforma.getText().toString();
                String genero = edAtualizaGenero.getText().toString();


                Pessoa pessoa = new Pessoa();
                pessoa.setEmail(email);
                pessoa.setId(userId);
                pessoa.setNome(userNome);
                pessoa.setProdutora(produtora);
                pessoa.setPlataforma(plataforma);
                pessoa.setGenero(genero);


                MainActivity.myAppDatabase.myDAO().atualizarPessoa(pessoa);

                Toast.makeText(getActivity(), "Aluno Atualizado com Sucesso!", Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }

}
