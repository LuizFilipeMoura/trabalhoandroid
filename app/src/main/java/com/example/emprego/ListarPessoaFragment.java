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
public class ListarPessoaFragment extends Fragment {

    TextView tv;


    public ListarPessoaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listar_pessoas, container, false);

        tv = view.findViewById(R.id.tvEmpregos);

        List<Pessoa> pessoaList = MainActivity.myAppDatabase.myDAO().listarPessoas();


        String info = "";

        for (Pessoa pessoa : pessoaList) {
            int id = pessoa.getId();
            String nome = pessoa.getNome();
            String email = pessoa.getEmail();
            String produtora = pessoa.getProdutora();
            String plataforma = pessoa.getPlataforma();
            String genero = pessoa.getGenero();

            info = info + "\n\n" + "ID:" + id +
                    "\n" + "Nome: " + nome +
                    "\n" + "Id do curso: " + email +
                    "\n" + "CPF: " + produtora +
                    "\n" + "Email: " + plataforma +
                    "\n" + "Telefone: " + genero;

        }

        tv.setText(info);


        return view;
    }

}
