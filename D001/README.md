# Aufgabenstellung

In dieser Aufgabe sollen Sie einen Sudoku Solver programmieren.
Die Benutzeroberfläche soll so aussehen wie im beiliegenden Screenshot (screenshot.png) gezeigt.
In den folgenden Aufgabentexten werden die konkreten Anforderungen festgelegt.
Beachten Sie darüber hinaus die Beschreibungen in der Javadoc.
Von den vorgegebenen Methoden dürfen Sie die Signaturen nicht verändern.
Die Aufgabe muss mit Java Swing gelöst werden.

In dieser Aufgabe verwenden wir die Grundregeln des Sudoku.
Es wird auf einem 9x9 Feld gespielt.
Jede Zelle muss eine Ziffer von 1 bis 9 enthalten und in jeder Zeile, jeder Spalte und jedem 3x3 Teilquadrat darf jede Ziffer nur einmal vorkommen. 

## Grundlegender Aufbau

Ihr Hauptfenster wird durch eine Klasse `Sudoku` bereitgestellt.
Es soll eine Menüleiste mit einem `MainMenu` enthalten,
das Sudoku Spielfeld (`Field`) anzeigen.
Im unteren Bereich soll ein `ButtonPanel` angezeigt werden,
welches die drei Buttons _Speichern_, _Prüfen_ und _Lösen_ anbietet.  
Überlassen Sie dem Window Manager Ihres Desktops wo das Fenster platziert wird.

## Anforderungen an das Layout

- Das Spielfeld darf und soll eine feste Größe haben
- Jede Sudoku-Zelle soll 40x40 Pixel groß sein
- Die minimalgröße des Fensters um das Spielfeld und das Button-Panel zu enthalten soll automatisch berechnet werden
- Wenn das Fenster vergrößert wird, soll das Spielfeld weiterhin mittig dargestellt werden, aber nicht mitskalieren.
- Die Buttons dürfen keine feste Größe haben und der Text muss immer vollständig lesbar sein.

## Anforderungen an das Hauptmenü

Es soll ein Menü _Datei_ und ein Menü _Info_ geben (Mnemonics: d und i).
Das Menü Info soll lediglich einen Menüpunkt _Über..._ enthalten (Mnemnoic b, Shortcut F1), der einen kleinen Info-Dialog anzeigt,
in dem Sie beispielsweise Ihren Namen unterbringen können (Sudoku-Solver von Mein Name).

Das Menü Datei soll folgende Einträge enthalten:
- Neu (Mnemonic n, Shortcut Ctrl+N)
- Öffnen (Mnemonic f, Shortcut Ctrl+O)
- Speichern (Mnemonic s, Shortcut Ctrl+S)
- Speichern als... (Mnemonic a, keinen Shortcut)
- Separator
- Prüfen (Mnemonic p, Shortcut Ctrl+P)
- Lösen (Mnemonic l, Shortcut Ctrl+L)
- Separator
- Beenden (Mnemonic e, keinen Shortcut)

Sämtliche Aktionen müssen in der Klasse `ActionHandler` implementiert werden.

Die Menüs Neu und Öffnen sollen bei ungespeicherten Änderungen fragen, ob der Benutzer speichern möchte.
Auswahlmöglichkeiten sollen sein: Ja, Nein, Abbrechen.
Bei Ja soll sich das Programm verhalten wie bei einem Klick auf Speichern.
Bei Nein soll einfach fortgefahren werden und bei Abbrechen wird Neu oder Öffnen abgebrochen.
Nach dem Öffnen einer Datei ist keine Zelle im Zustand _modifiziert_ (siehe unten).
_Prüfen_ soll eine Dialogbox anzeigen, die das Ergebnis der Prüfung (siehe unten) anzeigt.
Der Typ der Dialogbox soll bei erfolgreicher Prüfung INFORMATION sein und bei fehlgeschlagener Prüfung WARNING.
_Lösen_ soll das Feld lösen (siehe unten) oder, wenn das Feld nicht lösbar ist, eine Dialogbox vom Typ WARNING anzeigen.

Das Verhalten von Speichern und Speichern als... soll wie aus vielen anderen Programmen bekannt umgesetzt werden.
Wenn noch kein Dateiname bekannt ist, soll sich Speichern verhalten wie Speichern als. 
Andernfalls soll speichern ohne Rückfrage direkt speichern, während Speichern als immer nach einem Dateinamen fragt. 
Wenn in einem Speichern-Dialog eine bereits existierende Datei ausgewählt wird, soll der Benutzer gefragt werden, ob diese Datei überschrieben werden soll.
Wenn eine Datei gespeichert wird, sollen alle Zellen des Feldes auf _nicht modifiziert_ gesetzt werden.

### Abgrenzungen

Folgende Features müssen Sie **nicht** implementieren:
- Sicherheitsabfrage, wenn Alt+F4 gedrückt wird
- Sicherheitsabfrage, wenn das Fenster über den Schließen-Button im Frame geschlossen wird
- Öffnen/Speichern Dialoge brauchen nicht nach einer bestimmten Dateiendung zu filtern

## Anforderungen an das Dokumentformat

Das Format soll eine Textdatei sein, das ein leserliches Sudoku-Feld enthält.
Leere Zellen werden durch Unterstriche markiert. Hier sehen Sie ein Beispiel:
```
_ 1 _ 9 _ _ 8 _ _
_ _ _ _ _ 8 _ _ 4
6 _ 5 _ _ _ 7 _ _
_ 9 _ _ 6 _ _ _ 8
_ _ _ 2 _ 7 _ _ _
8 _ _ _ 3 _ _ 6 _
_ _ 2 _ _ _ 5 _ 3
1 _ _ 4 _ _ _ _ _
_ _ 6 _ _ 2 _ 1 _
```
Wenn eine zu öffnende Datei nicht diesem Format entspricht,
soll der Benutzer einen Fehlerdialog angezeigt der den Hinweis "Kein Sudoku-Feld enthalten!" enthält.
Sie erhalten drei Dateien mit unterschiedlich schwierigen Sudokus zum Testen.

## Anforderungen an das Button Panel

Die Buttons sollen lediglich schnelle Alternativen für die entsprechenden Hauptmenüpunkte sein.
Sowohl das Hauptmenü als auch die Buttons müssen denselben Code aufrufen (keine Code-Duplikation!).

## Anforderungen an das Spielfeld

- Das Gitternetz soll wie im Screenshot gezeigt gezeichnet werden.
D.h. jedes Teilquadrat muss mit etwas dickeren Linien umrandet sein.
- Die Eingabefelder dürfen nur Ziffern von 1 bis 9 akzeptieren oder leer sein.
- Entfernen und Backspace zum Löschen einer Ziffer müssen funktionieren.
- Markieren und überschreiben einer Ziffer muss funktionieren.
- Eine geänderte Zelle (modifiziert) soll blaue Textfarbe haben.
- Gespeicherte Zellen (unmodifiziert) sollen schwarze Textfarbe haben.
- Der Spielfeldhintergrund soll komplett weiß sein.
- Die Textfelder dürfen nicht als solche erkennbar sein. Für den Benutzer soll es sich anfühlen, als würde er direkt in das Gitternetz seine Ziffern eingeben.
- Jedes Textfeld soll 40x40 groß sein und horizontal zentrierten Text in Schriftgröße 18 enthalten.
- Wenn ein Textfeld den Fokus erhält, soll die darin ggf. enthaltene Ziffer markiert werden.
- Wenn ein Textfeld den Fokus verliert, soll möglicherweise noch markierter Text nicht länger markiert sein.

## Anforderungen an den Solver

Der Solver soll zwei Funktionen haben: Prüfen und Lösen.
Beim Prüfen soll der Solver lediglich das Einhalten der Regeln überprüfen.
Insbesondere soll beim Prüfen **nicht** die lösbarkeit (und schon gar nicht die eindeutige Lösbarkeit) des Feldes geprüft werden.
Das Prüfen soll auch auf noch nicht vollständig ausgefüllten Feldern möglich sein.
Beim Lösen soll der Solver eine (möglicherweise nicht eindeutige) Lösung berechnen und direkt in das Feld schreiben.
Falls es keine Lösung gibt, soll der Solver `false` zurückgeben und das Feld unverändert lassen.
Alle vom Solver gelöste Zellen sollen im Zustand _modifiziert_ sein.
Der Solver muss eine Lösung so schnell berechnen können, dass ein Aufruf direkt aus dem Event Dispatch Thread problemlos möglich ist und das UI nicht einfriert. 
