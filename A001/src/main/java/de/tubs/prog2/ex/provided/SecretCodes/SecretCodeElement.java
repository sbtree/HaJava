package de.tubs.prog2.ex.provided.SecretCodes;

/**
 * Abstract class für das Secret Code Element. Auf diese Weise koennen wir ganz bequem nachher
 * neues Verhalten hinzufuegen. Beispielsweise koennen wir nachher Zahlen als Code
 * benutzen, oder Strings, oder Melodien. Für jede dieser Typen koennen wir dann eine Klasse
 * erstellen, die die Klasse hier implementiert.
 */
public abstract class SecretCodeElement {

    protected String schluessel;
    protected int seed;

    /** Erzeugt ein neues SecretCodeElement
     *
     * @param seed Der Seed
     */
    public SecretCodeElement(int seed) {
        this.seed = seed;
    }

    /**
     * Vergleiche internes Element mit uebergebenen Element.
     * @param a uebergebenes Element
     * @return True falls gespeichertes Element gleich uebergebenes Element a ist.
     */
    public abstract boolean match(SecretCodeElement a);

    /**
     * Zeigt oder spielt etwas ab, wenn aufgerufen.
     */
    public abstract void printOrPlay();

    /**
     * Gibt den Schlüssel zurück
     * @return Der Schlüssel
     */
    public String getSchluessel() {
        return schluessel;
    }
}
