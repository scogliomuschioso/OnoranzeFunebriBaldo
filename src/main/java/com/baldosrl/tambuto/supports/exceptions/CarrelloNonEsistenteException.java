package com.baldosrl.tambuto.supports.exceptions;

public class CarrelloNonEsistenteException extends RuntimeException {
    public CarrelloNonEsistenteException() {
        super("il carrello selezionato non esite!");
    }
}
