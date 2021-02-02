package com.gabriel.martins.apinaescola.model.enums;

public enum STATUS_CLASSE {
    ATIVA("Ativa"),
    INATIVA("Inativa"),
    SUSPENSA("Suspensa");

    private String label;

    STATUS_CLASSE(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
