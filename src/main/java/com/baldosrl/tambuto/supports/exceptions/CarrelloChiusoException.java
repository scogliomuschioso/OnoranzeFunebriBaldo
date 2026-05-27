package com.baldosrl.tambuto.supports.exceptions;

public class CarrelloChiusoException extends RuntimeException {
    public CarrelloChiusoException() {
        super("non si possono aggiungere articoli in un carrello già chiuso");
    }
}
