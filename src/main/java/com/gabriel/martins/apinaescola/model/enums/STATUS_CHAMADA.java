package com.gabriel.martins.apinaescola.model.enums;

public enum STATUS_CHAMADA {
    PRESENTE("Presente"),
    AUSENTE("Ausente"),
    JUSTIFICADO("Justificado"),
    ATESTADO("Atestado");

    private String label;

    STATUS_CHAMADA(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
