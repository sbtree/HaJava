# Aufgabenstellung

Im beiliegenden Paket finden Sie ein Interface `SafeList` für eine _sichere_ Liste. 
Ihre Aufgabe besteht darin, das Interface auf zweierlei Arten zu implementieren: als `SafeArrayList` und als `SafeLinkedList`.
Verwenden Sie unbedingt diese beiden Klassennamen für Ihre Implementierung, da die Implementierungen automatisch getestet werden.

## Ihre Implementierung soll folgende Anforderungen erfüllen

- Die Spezifikationen in der Javadoc sollen umgesetzt werden.
- Alle Methoden sollen parallel aufrufbar, sein ohne die konsistenz der Liste zu beeinträchtigen.
- Die Methoden dürfen nicht `synchronized` sein.
- Die Länge der Liste soll immer den aktuellen Stand widerspiegeln.
    - Präziser: alle Änderungen müssen beim Abrufen der Länge _sichtbar_ sein.
- Alle Leseoperationen sollen so effizient wie möglich sein.
    - Sie dürfen davon ausgehen, dass aus den Listen sehr viel öfter gelesen als in sie geschrieben wird.
- Parallele Aufrufe der `set()` Methode dürfen nicht blockieren.
    - Hinweis: vermeiden Sie einen Write-Lock beim Ändern des Elementes.
- Alle Tests in der zur Verfügung gestellten Testklasse `SafeListTest` müssen erfolgreich sein. Andernfalls wird die jeweilige Implementierung mit 0 Punkten bewertet.

## Spezielle Anforderungen an die verkettete Liste

- Die Liste soll einfach verkettet sein.
- Das Abrufen der Länge soll in konstanter Zeit möglich sein.
- Suchoperationen in der Liste dürfen nicht andere Operationen blockieren.
    - Hinweis: vermeiden Sie einen Read-Lock beim Suchen in der Liste.
- Denken Sie daran, dass die Klasse zur Kapselung eines Listen-Items ein internes Implementierungsdetail der Liste sein sollte.

## Spezielle Anforderungen an die Array-basierte Liste

- Das zugrunde liegende Array darf nicht bei jeder Änderung neu erstellt werden.
    - Hinweis: arbeiten Sie mit einer Kapazität und verwalten Sie die tatsächliche Länge separat.
    - Wenn viele Elemente wieder gelöscht werden, soll die Kapazität wieder verkleinert werden.
    - Achten Sie darauf, dass die Grenze zum Verkleinern nicht exakt die Grenze zum Vergrößern der Kapazität sein darf, um ständige Änderungen der Kapazität beim wechselnden Hinzufügen und Entfernen von Elemente an der Kapazitätsgrenze zu vermeiden.  
- Die Implementierung kann ohne Verwendung einer `for`-Schleife (und ohne äquivalente Formulierungen mit `do` / `while`) erfolgen. Schauen Sie, ob Sie in der Klasse `System` etwas nützliches finden, um einen Bonuspunkt zu erhalten.
