package de.tubs.prog2.ex.provided.Suchstrategie;

import de.tubs.prog2.ex.provided.Mauer.Mauer;
import de.tubs.prog2.ex.provided.Wanderer.StandardWanderer;



/**
 * Wir implementieren die Suchstrategie hier auch als abstrakte Klasse. Wieso?
 * Weil wir damit auf ganz einfache Weise die Strategie austauschen koennen (also wie wir suchen).
 * Es kann ja verschiedene Weisen geben, wie wir die Mauer absuchen. Über die abstrakte Klasse
 * müssen wir nur einmal am Anfang definieren, was unsere Strategie ist. All der danach
 * folgende Code kann die gleichen Methodenaufrufe nutzen.
 * Auch hier nutzen wir wieder auf elegante Weise ein DesignPattern, naemlich das "Strategy Pattern".
 */
public abstract class SuchStrategie {

    protected Mauer mauer;
    protected StandardWanderer wanderer;

    /**
     * Erzeugt eine neue SuchStrategie
     * @param mauer Die Mauer
     * @param wanderer Die suchende Person
     */
    public SuchStrategie(Mauer mauer, StandardWanderer wanderer) {
        this.mauer = mauer;
        this.wanderer = wanderer;
    }

    /**
     * Starte Suche
     * @return true falls die Suche erfolgreich war.
     */
    public abstract boolean starteSuche();

}
