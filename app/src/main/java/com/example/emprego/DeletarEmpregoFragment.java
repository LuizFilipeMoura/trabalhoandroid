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
public class DeletarEmpregoFragment extends Fragment {

    Button buttonExcluirUsuario;
    EditText edExcluirUsuario;

    public DeletarEmpregoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deletar_emprego, container, false);

        buttonExcluirUsuario = view.findViewById(R.id.buttonExcuirPessoa);
        edExcluirUsuario = view.findViewById(R.id.editTextExcluirPessoa);

        buttonExcluirUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(edExcluirUsuario.getText().toString());
                Emprego emprego = new Emprego();

                emprego.setId(id);

                MainActivity.myAppDatabase.myDAO().deletarEmprego(emprego);

                Toast.makeText(getActivity(), "Curso Deletado com Sucesso!", Toast.LENGTH_LONG).show();

            }
        });


        return view;
    }

}
