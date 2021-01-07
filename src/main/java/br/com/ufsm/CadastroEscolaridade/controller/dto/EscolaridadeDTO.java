package br.com.ufsm.CadastroEscolaridade.controller.dto;

import br.com.ufsm.CadastroEscolaridade.entity.EscolaridadeEntity;
import br.com.ufsm.CadastroEscolaridade.model.Escolaridade;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EscolaridadeDTO {

    private String nome;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String instituicao;

    public EscolaridadeDTO() {
    }

    public EscolaridadeDTO(EscolaridadeEntity escolaridade) {
        this.nome = escolaridade.getNome();
        this.dataInicial = escolaridade.getDataInicial();
        this.dataFinal = escolaridade.getDataFinal();
        this.instituicao = escolaridade.getInstituicao();
    }

  /* public static List<EscolaridadeDTO> converter(List<EscolaridadeEntity> escolaridades) {
        return escolaridades.stream().map(EscolaridadeDTO::new).collect(Collectors.toList());
    }*/


    public static List<EscolaridadeDTO> converter(List<EscolaridadeEntity> escolaridades) {
        return escolaridades.stream().map(EscolaridadeDTO::new).collect(Collectors.toList());
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public String getInstituicao() {
        return instituicao;
    }
}
