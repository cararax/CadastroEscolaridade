package br.com.ufsm.CadastroEscolaridade.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table( name = "escolaridade" )

public class EscolaridadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "dataInicial", nullable = false)
    private LocalDate dataInicial;

    @Column(name = "dataFinal", nullable = false)
    private LocalDate dataFinal;

    @Column(name = "instituicao", nullable = false)
    private String instituicao;

    public EscolaridadeEntity() {
    }

    public EscolaridadeEntity(Integer id, String nome, LocalDate dataInicial, LocalDate dataFinal, String instituicao) {
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
