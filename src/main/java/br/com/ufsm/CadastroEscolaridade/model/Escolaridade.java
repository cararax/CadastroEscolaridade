package br.com.ufsm.CadastroEscolaridade.model;

import java.time.LocalDate;

public class Escolaridade {

    private Integer id;
    private String nome;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String instituicao;


    public Escolaridade() {
    }

    public Escolaridade(Integer id, String nome, LocalDate dataInicial, LocalDate dataFinal, String instituicao) {
        this.id = id;
        this.nome = nome;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.instituicao = instituicao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
}
