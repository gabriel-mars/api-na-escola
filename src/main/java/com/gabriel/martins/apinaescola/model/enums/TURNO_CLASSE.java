package com.gabriel.martins.apinaescola.model.enums;

public enum TURNO_CLASSE {
    MATITUNO("Matituno"),
    VESPERTINO("Vespertino"),
    NOTURNO("Noturno");

    private String label;

    TURNO_CLASSE(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
