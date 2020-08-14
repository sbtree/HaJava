package de.tubs.prog2.ex.provided.SecretCodes;

/**
 * Ein Generator für die Secret Code Erstellung.
 * Uebrigens: Wir orientieren uns mit dem SecretCodeGenerator und dem SecretCodeElement an dem
 * Abstract Factory Design Pattern.
 * (Link: https://www.philipphauer.de/study/se/design-pattern/abstract-factory.php)
 * Damit koennen wir Code so schreiben, dass wir ihn spaeter sehr bequem erweitern koennen.
 * Schauen Sie sich ruhig mal den Link an; es ist aber nicht noetig, die Design Patterns zu kennen
 * zur Loesung dieser Hausaufgabe.
 */
public abstract class SecretCodeGenerator {

    /**
     * Erzeugt das nächste SecretCodeElement
     * @param seed Der zu verwendende Seed
     * @return Das nächste Element.
     */
    public abstract SecretCodeElement createNext(int seed);

}
