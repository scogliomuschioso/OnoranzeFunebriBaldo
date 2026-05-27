package com.baldosrl.tambuto.supports.exceptions;

public class QuantitaMinoreDiZeroException extends RuntimeException {
    public QuantitaMinoreDiZeroException() {
        super("la quantità selezionata è minore di 0");
    }
}
