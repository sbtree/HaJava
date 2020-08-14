package de.tubs.prog2.ex.provided.Mauer;

import de.tubs.prog2.ex.provided.Fehler.CheatException;
import de.tubs.prog2.ex.provided.SecretCodes.SecretCodeElement;
import de.tubs.prog2.ex.provided.SecretCodes.SecretCodeGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Die unendlich lange Stadtmauer
 */
public class Mauer {

    /**
     * Die Startposition des Wanderers ist 0.
     * torPosition gibt dazu relativ die Tor Position an. Ein positiver Index bedeutet, dass das Tor rechts
     * von der initialen Position des Wanderes liegt. Ein negativer Index links.
     */
    private int torPosition;

    /**
     * Die Laenge des Codes, welcher noetig ist, um das Tor passieren zu duerfen.
     */
    private int codeLaenge;

    /**
     * Der Geheimcode, der noetig ist, um den Eingang passieren zu duerfen.
     */
    private List<SecretCodeElement> mauerGeheimcode;

    /**
     * Ein Generator, um die Bestandteile des Geheimcodes zu erzeugen. Auf diese Weise koennen wir die
     * Art des Geheimcodes leicht austauschen. Beispielsweise koennen wir Zahlen, Buchstaben oder gar Musik benutzen.
     */
    private SecretCodeGenerator secretCodeGenerator;

    private int letzteAbgefragtePosition = 0;
    private int seed;

    /**
     * Speichert ob das Tor erfolgreich erreicht worden ist mit der richtigen Zugriffssequenz.
     */
    private boolean torZugriffErlaubt = false;

    /**
     * Default Konstruktor.
     * @param torPosition Die Position des Tores, entweder negativ (wenn das Tor links vom Wanderer ist), oder
     *                    positiv (wenn das Tor rechts vom Wanderer ist). Beispielsweise bedeutet TorPosition=-5, dass
     *                    das Tor fuenf Schritte links vom Wanderer liegt.
     * @param secretCodeGenerator ein Generator, um die Secret Code Elemente zu erzeugen
     * @param seed ein Seed, um die Erstellung der Zufallszahlen zu initiieren.
     */
    public Mauer(int torPosition, SecretCodeGenerator secretCodeGenerator, int seed) {

        this.torPosition = torPosition;
        this.codeLaenge = 6;
        this.seed = seed;
        this.secretCodeGenerator = secretCodeGenerator;
        this.mauerGeheimcode = new ArrayList<>(codeLaenge);
    }

    /**
     * Ueberpruefe ob an aktueller Position das Tor liegt.
     * @param position Position des Wanderers.
     * @return True falls an aktueller Position das Tor liegt.
     * @throws CheatException - wenn etwas nicht stimmt.
     */
    public boolean ueberpruefeTor(int position) throws CheatException {

        // Wir ueberpruefen ob die aktuell gepruefte Position um mehr als eins abweicht. Das bedeutet,
        // dass wir Positionen uebersprungen haben an der Mauer. Das geht so nicht! Der Wanderer kann nur laufen!
        if (Math.abs(position - letzteAbgefragtePosition) > 1) {
            throw new CheatException("You are cheating. Hermine cannot fly!");
        }
        letzteAbgefragtePosition = position;

        return position == torPosition;
    }

    /**
     * Rufe geheimes Element an aktuellen Mauerstueck ab.
     * @param position aktuelle Mauerposition
     * @return geheimes Element
     */
    public SecretCodeElement erhalteMauerSecretCodeStueck(int position) {

        // A. Checks
        if (position > 0 && this.torPosition > 0 && position > this.torPosition) {
            throw new CheatException("Der/Die Wanderer*in hat wohl das Tor uebersehen."
                    + " Wie sonst hat sie/er es ueber das Tor hinausgeschafft rechts von der Startposition?"
            );
        }
        if (position < 0 && this.torPosition < 0 && position < this.torPosition) {
            throw new CheatException("Der/Die Wanderer*in hat wohl das Tor uebersehen."
                    + " Wie sonst hat sie/er es ueber das Tor hinausgeschafft links von der Startposition?"
            );
        }

        // B. Secret Code Element
        SecretCodeElement secretCodeElement = this.secretCodeGenerator.createNext(this.seed);
        SecretCodeElement returnSecretCodeElement = this.secretCodeGenerator.createNext(this.seed);
        // Wir rufen die Methode 2x auf---mit dem gleichen Seed. Wir erhalten also ein neues Objekt
        // mit gleichem Inhalt. Damit erhalten wir also eine Art Kopie. Das machen wir hier, damit die Mauer
        // ein eigenes secretCodeElement hat, und dem Wanderer eine eigene Version gibt --- aus Sicherheitsgruenden.
        this.seed++;


        // C. Speichern des Secret Code Elements
        if (Math.abs(position - this.torPosition) > (this.codeLaenge - 1)) {
            // Ok, der Wanderer ist noch weit weg.
            this.mauerGeheimcode.clear();
            return returnSecretCodeElement;
        }

        // ok, der Wanderer ist nah dran. Wir fangen schon mal an, die Geheimsequenz zu speichern.
        int delta = Math.abs(position - this.torPosition);

        this.mauerGeheimcode.add(this.codeLaenge - 1 - delta, secretCodeElement);
        return returnSecretCodeElement;
    }

    /**
     * Uebergebe dem Tor den Geheim Code, damit dieser pruefen kann, dass die Sequenz korrekt ist.
     * @param magierMauerGeheimcode  Geheim-Code
     * @return True falls die Sequenz stimmt und der Wanderer in die Stadt darf.
     */
    public boolean uebergebeTorGeheimCode(List<SecretCodeElement> magierMauerGeheimcode) {

        // 1. Sind die Listen gleich lang?
        if (this.mauerGeheimcode.size() != magierMauerGeheimcode.size()) {
            return false;
        }

        // 2. Enthalten die Listen die gleichen Codes. Wir ueberlassen die Klasse SecretCodeElement
        //      die Ueberpruefung. Dadurch kann jede Klasse selbst das Verhalten implementieren.
        for (int i = 0; i < this.mauerGeheimcode.size(); i++) {
            if (!this.mauerGeheimcode.get(i).match(magierMauerGeheimcode.get(i))) {
                return false;
            }
        }

        // 3. Zu guter Letzt: Wir zeigen den Secret Code oder spielen eine Melodie ab, wenn alles erfolgreich ist.
        for (SecretCodeElement secretCodeElement : this.mauerGeheimcode) {
            secretCodeElement.printOrPlay();
        }

        this.torZugriffErlaubt = true;
        return true;
    }

    /**
     * True/False falls der Einlass in die Stadt moeglich ist.
     * @return True/False ueber Tor Eintritt
     */
    public boolean isTorZugriffErlaubt() {
        return this.torZugriffErlaubt;
    }

    /**
     * Gebe Code Laenge zurueck
     * @return Code Laenge
     */
    public int getCodeLaenge() {
        return this.codeLaenge;
    }

}
