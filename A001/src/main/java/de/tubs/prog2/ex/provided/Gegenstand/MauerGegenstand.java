package de.tubs.prog2.ex.provided.Gegenstand;

/**
 * Ein MauerGegenstand
 */
public class MauerGegenstand implements Gegenstand {

    /**
     * Der Wert des Gegenstands
     */
    private int wert;

    /**
     * Erzeugt einen neuen MauerGegenstand
     * @param wert Der entsprechende Wert
     */
    public MauerGegenstand(int wert) {
        this.wert = wert;
    }

    @Override
    public int getWert() {
        return this.wert;
    }

}
