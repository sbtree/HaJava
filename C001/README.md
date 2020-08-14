# Aufgabenstellung

In dieser Aufgabe sollen Sie einen einfachen nichtdeterministischen endlichen Automaten implementieren.
Der Automat soll beliebig viele Initialzustände und beliebig viele Finalzustände haben.
Transitionen führen von einem Zustand durch Konsumieren eines Symbols zu einem anderen Zustand.
Wir interessieren uns dafür, welche Worte (d.h. Sequenz von Symbolen) dieser Automat _akzeptiert_.
Ein Wort wird im Automaten wie folgt verarbeitet:

- Starte in einem beliebigen Initialzustand
- Betrachte das erste Symbol im Wort und wähle eine Transition die dieses Symbol konsumiert
- Gehe in den entsprechenden Zielzustand über und konsumiere die restlichen Symbole auf die gleiche Weise, bis keine mehr übrig sind

Da von einem beliebigen Initialzustand aus gestartet werden kann und die Wahl der Transition nicht eindeutig sein muss, erhalten wir auf diese Weise viele mögliche Abläufe im Automaten.
Der Automat akzeptiert das Wort, wenn es mindestens einen Ablauf gibt, der in einem Finalzustand endet.

Ihre Aufgabe ist es nun dieses Automatenmodell zu implementieren und zwei parallele Berechnungsstrategien zu entwickeln.
Stellen Sie sich die oben beschriebene Berechnung als einen Baum vor (mit einem künstlichen Wurzelknoten der jeden Initialzustand als Kind hat).
Dann soll Ihre Berechnung an einer Verzweigung in diesem Baum einen Pfad die weitere Berechnung der Teilbäume parallelisieren.

Sie können bei der Implementierung wie folgt vorgehen:

1. Implementieren Sie zuerst `Symbol`, `Word`, `AutomatonState` und `Pair` wie in der Javadoc beschrieben.
2. Anschließend implementieren Sie `NFA` bis zu dem Punkt, an dem Sie die `AcceptanceStrategy` aufrufen.
3. Zuletzt implementieren Sie die beiden Strategien. 

In der Strategie `NFAThreadsAcceptanceStrategy` sollen Sie eigene Thread erzeugen und verwalten.
Denken Sie an die Aussagen aus der Vorlesung und der Übung zum sauberen Beenden der Threads.
In der anderen Strategie - `NFAModernAcceptanceStrategy` - sollen Sie komplett auf eigene Threads verzichten.
Es gibt viele Möglichkeiten, wie Sie das tun können. Wenn Sie einen `Executor` verwenden, was Sie nicht müssen, achten Sie aber darauf, dass er sauber beendet wird.
Sie dürfen die Namen dieser Klassen nicht verändern, da Ihre Implementierungen später automatisch überprüft werden.

Es sei Ihnen ans Herz gelegt, Ihre Implementierung mit weiteren Unit-Tests zu überprüfen.

**Wichtig:** Ihr gesamter Code (sowohl `main` als auch `test`) soll im Paket `student` verortet sein.
Code in einem anderen Paket wird nicht gewertet.

## Beispiel

Der folgende Automat akzeptiert die Sprache `aa(a|b)*bb`,
also genau die Wörter, die mit zwei `a` anfangen und zwei `b` enden und dazwischen beliebige Kombinationen von `a` und `b` enthalten. 

```
final var nfa = new NFA();

final Symbol
        a = new Symbol('a'),
        b = new Symbol('b');

final AutomatonState
        initial = new AutomatonState(0),
        firstA = new AutomatonState(1),
        secondAandLoop = new AutomatonState(2),
        firstB = new AutomatonState(3),
        secondB = new AutomatonState(4);

nfa.declareInitialState(initial);
nfa.declareFinalState(secondB);

nfa.addTransition(initial, a, firstA);
nfa.addTransition(firstA, a, secondAandLoop);
nfa.addTransition(secondAandLoop, a, secondAandLoop);
nfa.addTransition(secondAandLoop, b, secondAandLoop);
nfa.addTransition(secondAandLoop, b, firstB);
nfa.addTransition(firstB, b, secondB);
```
