package com.gabriel.martins.apinaescola.model.enums;

public enum TIPO_USUARIO {
    ESCOLA("Escola"),
    PROFESSOR("Professor(a)"),
    SECRETARIA("Secretário(a)"),
    PEDAGOGA("Pedagogo(a)"),
    ASSISTENTE("Assistente"),
    SUPERVISOR("Supervisor(a)"),
    ORIENTADOR("Orientador(a)");

    private String label;

    TIPO_USUARIO(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}