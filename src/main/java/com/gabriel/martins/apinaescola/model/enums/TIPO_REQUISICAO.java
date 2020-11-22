package com.gabriel.martins.apinaescola.model.enums;

public enum TIPO_REQUISICAO {
    LIBERACAO("Liberação"),
    COMPROVANTE("Comprovante"),
    DOCUMENTACAO("Documentação"),
    OUTROS("Outros");

    private String label;

    TIPO_REQUISICAO(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
