package com.example.emprego;

public class Emprego {
    private int vagaId;
    private String descricao;
    private int horasSemana;
    private double valor ;

    public Emprego(int vagaId, String descricao, int horasSemana, double valor) {
        this.vagaId = vagaId;
        this.descricao = descricao;
        this.horasSemana = horasSemana;
        this.valor = valor;
    }

    public int getVagaId() {
        return vagaId;
    }

    public void setVagaId(int vagaId) {
        this.vagaId = vagaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getHorasSemana() {
        return horasSemana;
    }

    public void setHorasSemana(int horasSemana) {
        this.horasSemana = horasSemana;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Emprego() {
    }
}
