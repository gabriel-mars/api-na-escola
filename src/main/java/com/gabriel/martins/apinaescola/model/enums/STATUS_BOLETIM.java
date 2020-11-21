package com.gabriel.martins.apinaescola.model.enums;

public enum STATUS_BOLETIM {
    APROVADO("Aprovado"),
    CURSANDO("Cursando"),
    REPROVADO("Reprovado"),
    RECUPERACAO("Recuperação"),
    TRANSFERIDO("Transferido");

    private String label;

    STATUS_BOLETIM(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
