package com.baldosrl.tambuto.supports.exceptions;

public class ArticoloGiaPresenteException extends RuntimeException {
    public ArticoloGiaPresenteException() {
        super("l'articolo inserito è già presente");
    }
}
