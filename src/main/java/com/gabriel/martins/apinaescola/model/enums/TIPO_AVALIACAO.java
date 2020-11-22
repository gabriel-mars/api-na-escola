package com.gabriel.martins.apinaescola.model.enums;

public enum TIPO_AVALIACAO {
    PROVA("Prova"),
    TRABALHO("Trabalho"),
    CONCEITO("Conceito"),
    PROVA_E_TRABALHO("Prova e Trabalho"),
    PROVA_E_CONCEITO("Prova e Conceito"),
    TRABALHO_E_CONCEITO("Trabalho e Conceito");

    private String label;

    TIPO_AVALIACAO(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
