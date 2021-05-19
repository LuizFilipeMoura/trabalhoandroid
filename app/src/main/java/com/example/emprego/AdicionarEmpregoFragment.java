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
public class AdicionarEmpregoFragment extends Fragment {

    Button buttonInserirUsuario;
    EditText edInserirId, edInserirNome, edInserirEmail, edInserirValor;

    public AdicionarEmpregoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_adicionar_emprego, container, false);
        buttonInserirUsuario = view.findViewById(R.id.buttonInserir);
        edInserirEmail = view.findViewById(R.id.editTextHoras);
        edInserirId = view.findViewById(R.id.editTextInserirId);
        edInserirNome = view.findViewById(R.id.editTextInserirDescricao);
        edInserirValor = view.findViewById(R.id.editTextInserirValor);


        buttonInserirUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Emprego emprego = new Emprego();
                emprego.setHorasSemana(Integer.parseInt(edInserirEmail.getText().toString()));
                emprego.setValor(Float.parseFloat(edInserirValor.getText().toString()));
                emprego.setId(Integer.parseInt(edInserirId.getText().toString()));
                emprego.setDescricao(edInserirNome.getText().toString());

                MainActivity.myAppDatabase.myDAO().inserirEmprego(emprego);

                Toast.makeText(getActivity(), "Curso Inserido com Sucesso!", Toast.LENGTH_LONG).show();
            }
        });


        return view;


    }

}
