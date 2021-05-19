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
public class AtualizarEmpregoFragment extends Fragment {

    Button btAtualiza;
    EditText edAtId, edAtualizaNome, edAtualizaEmail;


    public AtualizarEmpregoFragment() {
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


        btAtualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userId = Integer.parseInt(edAtId.getText().toString());
                String userNome = edAtualizaNome.getText().toString();
                int horas = Integer.parseInt(edAtualizaEmail.getText().toString());


                Emprego emprego = new Emprego();
                emprego.setHorasSemana(horas);
                emprego.setId(userId);
                emprego.setDescricao(userNome);


                MainActivity.myAppDatabase.myDAO().atualizarEmprego(emprego);

                Toast.makeText(getActivity(), "Curso Atualizado com Sucesso!", Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }

}
