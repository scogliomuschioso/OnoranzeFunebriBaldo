package com.baldosrl.tambuto.supports.exceptions;

public class EmailGiaPresenteException extends RuntimeException {
    public EmailGiaPresenteException() {
        super("Email inserita è stata già usata nella creazione di un account");
    }
}
