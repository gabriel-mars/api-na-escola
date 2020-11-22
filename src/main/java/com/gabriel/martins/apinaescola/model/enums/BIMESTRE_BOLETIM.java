package com.gabriel.martins.apinaescola.model.enums;

public enum BIMESTRE_BOLETIM {
    PRIMEIRO("1º Bimestre"),
    SEGUNDO("2º Bimestre"),
    TERCEIRO("3º Bimestre"),
    QUARTO("4º Bimestre"),
    SEMESTRE_1("1º Semestre"),
    SEMESTRE_2("2º Semestre"),
    TRIMESTRE_1("1º Trimestre"),
    TRIMESTRE_2("2º Trimestre");

    private String label;

    BIMESTRE_BOLETIM(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
