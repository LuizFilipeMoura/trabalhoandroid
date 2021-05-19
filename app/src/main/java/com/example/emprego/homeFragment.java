package com.example.emprego;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.jonathas.aula01room.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment implements View.OnClickListener {

    Button btAdicionar, btAtualizar, btDeletar, btListar;
    Button btAdicionarC, btAtualizarC, btDeletarC, btListarC;

    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btAdicionar = view.findViewById(R.id.buttonInserirUsuario);
        btListar = view.findViewById(R.id.buttonListarUsuarios);
        btDeletar = view.findViewById(R.id.buttonDeletarUsuario);
        btAtualizar = view.findViewById(R.id.buttonAlterarUsuario);

        btAdicionarC = view.findViewById(R.id.buttonAddCurso);
        btListarC = view.findViewById(R.id.buttonListarCurso);
        btDeletarC = view.findViewById(R.id.buttonDeletarCurso);
        btAtualizarC = view.findViewById(R.id.buttonAlterarCurso);


        btAtualizar.setOnClickListener(this);
        btDeletar.setOnClickListener(this);
        btListar.setOnClickListener(this);
        btAdicionar.setOnClickListener(this);

        btAtualizarC.setOnClickListener(this);
        btDeletarC.setOnClickListener(this);
        btListarC.setOnClickListener(this);
        btAdicionarC.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonInserirUsuario:
                MainActivity.fragmentManager.beginTransaction().
                        replace(R.id.frameConteiner,
                                new AdicionarPessoaFragment()).
                        addToBackStack(null).commit();
                Toast.makeText(getActivity(), "Usuario selecionou a opção Inserir Jogo.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.buttonListarUsuarios:
                MainActivity.fragmentManager.beginTransaction().
                        replace(R.id.frameConteiner,
                                new ListarPessoaFragment()).
                        addToBackStack(null).commit();
                Toast.makeText(getActivity(), "Usuario selecionou a opção Listar Jogo.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonAlterarUsuario:
                MainActivity.fragmentManager.beginTransaction().
                        replace(R.id.frameConteiner,
                                new AtualizarPessoaFragment()).
                        addToBackStack(null).commit();
                Toast.makeText(getActivity(), "Usuario selecionou a opção Alterar Jogo.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonDeletarUsuario:
                MainActivity.fragmentManager.beginTransaction().
                        replace(R.id.frameConteiner,
                                new DeletarUsuarioFragment()).
                        addToBackStack(null).commit();
                Toast.makeText(getActivity(), "Usuario selecionou a opção Deletar Jogo.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonAddCurso:
                MainActivity.fragmentManager.beginTransaction().
                        replace(R.id.frameConteiner,
                                new AdicionarEmpregoFragment()).
                        addToBackStack(null).commit();
                Toast.makeText(getActivity(), "Usuario selecionou a opção Adicionar Curso.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonListarCurso:
                MainActivity.fragmentManager.beginTransaction().
                        replace(R.id.frameConteiner,
                                new ListarEmpregoFragment()).
                        addToBackStack(null).commit();
                Toast.makeText(getActivity(), "Usuario selecionou a opção Listar Curso.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonAlterarCurso:
                MainActivity.fragmentManager.beginTransaction().
                        replace(R.id.frameConteiner,
                                new AtualizarEmpregoFragment()).
                        addToBackStack(null).commit();
                Toast.makeText(getActivity(), "Usuario selecionou a opção Atualizar Curso.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonDeletarCurso:
                MainActivity.fragmentManager.beginTransaction().
                        replace(R.id.frameConteiner,
                                new DeletarEmpregoFragment()).
                        addToBackStack(null).commit();
                Toast.makeText(getActivity(), "Usuario selecionou a opção Deletar Curso.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
