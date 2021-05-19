package com.example.emprego;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DAO {

    @Insert
    public void inserirPessoa(Pessoa pessoa);

    @Query("select *from pessoas")
    public List<Pessoa> listarPessoas();

    @Delete
    public void deletarPessoa(Pessoa pessoa);

    @Update
    public void atualizarPessoa(Pessoa pessoa);

    @Insert
    public void inserirEmprego(Emprego emprego);

    @Query("select *from empregos")
    public List<Emprego> listarEmpregos();

    @Delete
    public void deletarEmprego(Emprego emprego);

    @Update
    public void atualizarEmprego(Emprego emprego);


}
