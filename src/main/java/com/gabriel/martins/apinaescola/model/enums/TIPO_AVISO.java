package com.gabriel.martins.apinaescola.model.enums;

public enum TIPO_AVISO {
    PROVA("Prova"),
    REUNIAO("Reunião"),
    LEMBRETE("Lembrete");

    private String label;

    TIPO_AVISO(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
