package com.baldosrl.tambuto.supports.exceptions;

public class UtenteNonTrovatoException extends RuntimeException {
    public UtenteNonTrovatoException() {
        super("l'utente inserito non esite");
    }
}
