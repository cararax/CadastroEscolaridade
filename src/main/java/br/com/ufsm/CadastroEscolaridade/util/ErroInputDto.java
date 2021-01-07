package br.com.ufsm.CadastroEscolaridade.util;

public class ErroInputDto {

    private String atributo;
    private String erro;

    public ErroInputDto(String atributo, String erro) {
        this.atributo = atributo;
        this.erro = erro;
    }

    public String getAtributo() {
        return atributo;
    }

    public String getErro() {
        return erro;
    }
}
