package com.gabriel.martins.apinaescola.model.enums;

public enum PERIODO_BOLETIM {
    PRIMEIRO_BIMESTRE("1º Bimestre"),
    SEGUNDO_BIMESTRE("2º Bimestre"),
    TERCEIRO_BIMESTRE("3º Bimestre"),
    QUARTO_BIMESTRE("4º Bimestre"),
    PRIMEIRO_SEMESTRE("1º Semestre"),
    SEGUNDO_SEMESTRE("2º Semestre"),
    PRIMEIRO_TRIMESTRE("1º Trimestre"),
    SEGUNDO_TRIMESTRE("2º Trimestre"),
    TERCEIRO_TRIMESTRE("3º Trimestre");

    private String label;

    PERIODO_BOLETIM(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
