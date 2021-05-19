package com.example.emprego;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jonathas.aula01room.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListarEmpregoFragment extends Fragment {

    TextView tv;


    public ListarEmpregoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listar_empregos, container, false);

        tv = view.findViewById(R.id.tvEmpregos);

        List<Emprego> cursosList = MainActivity.myAppDatabase.myDAO().listarEmpregos();


        String info = "";

        for (Emprego cursos : cursosList) {
            int id = cursos.getId();
            String nome = cursos.getDescricao();
            String email = cursos.getHorasSemana();

            info = info + "\n\n" + "ID:" + id +
                    "\n" + "Nome: " + nome +
                    "\n" + "Horas: " + email;

        }

        tv.setText(info);


        return view;
    }

}
