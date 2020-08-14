package de.tubs.prog2.ex.provided.Fehler;

/**
 * Exception, die wir werfen, wenn der Magier sich nicht an die Regeln haelt.
 */
public class CheatException extends RuntimeException {

    /**
     * Wirft eine Exception bei ungewoehnlichen Verhalten
     * @param errorMessage Fehlermeldung
     * @param err Throwable
     */
    public CheatException(String errorMessage, Throwable err) {
            super(errorMessage, err);
    }

    /**
     * Wirft eine Exception bei ungewoehnlichen Verhalten
     * @param errorMessage Fehlermeldung
     */
    public CheatException(String errorMessage) {
        super(errorMessage);
    }
}
