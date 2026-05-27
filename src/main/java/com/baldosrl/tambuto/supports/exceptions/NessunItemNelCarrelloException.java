package com.baldosrl.tambuto.supports.exceptions;

public class NessunItemNelCarrelloException extends RuntimeException {
    public NessunItemNelCarrelloException() {
        super("il carrello non ha nessun oggetto all'interno");
    }
}
