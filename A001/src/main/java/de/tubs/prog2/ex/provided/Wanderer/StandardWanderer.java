package de.tubs.prog2.ex.provided.Wanderer;

/**
 * Basisklasse für die Wanderer.
 */
public abstract class StandardWanderer {

    /**
     * Aktuelle Position des Wanderers. Start ist bei 0.
     */
    protected int position = 0;

    /**
     * Anzahl der maximalen Schritte, bis der Wanderer aufgibt.
     * Dieser Wert sollte alle insgesamt gemachten Schritte von Anfang an zaehlen, nicht nur eine Richtung.
     */
    protected int maxSchritte;

    /**
     * Erzeugt einen neuen Wanderer
     * @param maxSchritte Wie viele Schritte geht dieser Wanderer maximal?
     */
    public StandardWanderer(int maxSchritte) {
        this.maxSchritte = maxSchritte;
    }

    /**
     * Die aktuelle Position des Wanderers
     * @return Die Position (Start ist bei 0)
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Wie viele Schritte bis der Wanderer aufgibt?
     * @return Die maximale Anzahl an Schritten
     */
    public int getMaxSchritte() {
        return this.maxSchritte;
    }

    /**
     * Dinge, die der Wanderer erledigt, wenn er nach links geht.
     */
    public abstract void schittLinks();

    /**
     * Dinge, die der Wanderer erledigt, wenn er nach rechts geht.
     */
    public abstract void schrittRechts();

}
