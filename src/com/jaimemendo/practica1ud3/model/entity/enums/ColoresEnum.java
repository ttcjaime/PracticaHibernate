package com.jaimemendo.practica1ud3.model.entity.enums;

public enum ColoresEnum {
    NEGRO("Negro"),
    AMARILLO("Amarillo"),
    ROJO("Rojo"),
    BLANCO("Blanco"),
    AZUL("Azul"),
    VERDE("Verde"),
    MORADO("Morado"),
    INDIGO("Indigo"),
    ROSADO("Rosado"),
    CAFE("Cafe"),
    NARANJA("Naranja");

    private String valor;

    ColoresEnum(String valor) {this.valor = valor;}

    public String getValor() {return valor;}

}
