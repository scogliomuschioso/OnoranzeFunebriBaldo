package com.baldosrl.tambuto.supports.exceptions;

public class NonAbbastanzaUnitaException extends RuntimeException {
    public NonAbbastanzaUnitaException() {
        super("l'articolo selezionato non ha abbastanza unità");
    }
}
