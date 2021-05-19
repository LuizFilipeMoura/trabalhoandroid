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
public class DeletarUsuarioFragment extends Fragment {

    Button buttonExcluirUsuario;
    EditText edExcluirUsuario;

    public DeletarUsuarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deletar_pessoa, container, false);

        buttonExcluirUsuario = view.findViewById(R.id.buttonExcuirPessoa);
        edExcluirUsuario = view.findViewById(R.id.editTextExcluirPessoa);

        buttonExcluirUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(edExcluirUsuario.getText().toString());
                Pessoa pessoa = new Pessoa();

                pessoa.setId(id);

                MainActivity.myAppDatabase.myDAO().deletarPessoa(pessoa);

                Toast.makeText(getActivity(), "Aluno Deletado com Sucesso!", Toast.LENGTH_LONG).show();

            }
        });


        return view;
    }

}
