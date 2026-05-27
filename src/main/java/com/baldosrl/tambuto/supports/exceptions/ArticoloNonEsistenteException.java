package com.baldosrl.tambuto.supports.exceptions;

public class ArticoloNonEsistenteException extends RuntimeException {
    public ArticoloNonEsistenteException() {
        super("l'articolo selezionato non esiste");
    }
}
