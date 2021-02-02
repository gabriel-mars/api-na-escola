package com.gabriel.martins.apinaescola.model.enums;

public enum SITUACAO_ALUNO {
    REGULAR("Regular"),
    DOCUMENTACAO_PENDENTE("Documentação Pendente"),
    SUSPENSO("Suspenso"),
    EXPULSO("Expulso"),
    TRANSFERIDO("Transferido"),
    OUTRO("Outro");

    private String label;

    SITUACAO_ALUNO(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
