# Hausarbeit: Programmieren 2 Sommersemester 2020

Dieses Repository enthält den mitgelieferten Code für die Programmieren 2 Hausarbeit.

## Struktur

Diese Teilt sich in 4 Themenbereiche auf:

### Themenbereich A - Datenstrukturen

- A001: Eine unendliche Wand (Suchstrategie nach einem Eingang)

### Themenbereich B - Java Collections

- B001: ColoredGraph (ähnlich zu Siedler) mit unterschiedlichen Algorithmen.

### Themenbereich C - Concurrency

- C001: NFA mit parallelen Runs
- C002: Implementierungen einer thread-sicheren Liste

### Themenbereich D - GUI

- D001: Sudoku Solver

## Nutzung

Das Projekt nutzt Maven als Build Tool. Falls Sie keine IDE verwenden (etwa Eclipse oder IntelliJ IDEA), welche mit Maven Projekten direkt umgehen kann, sind im Folgenden einige Kommandos erklärt mit denen Sie mit das Projekt erfolgreich Bearbeiten und Testen können.

Die Maven eigenen Dateien (pom.xml) dürfen Sie auf **keinen Fall** verändern! Wir werden diese zur Bewertung auf den initialen Stand zurücksetzen. Wenn Ihre Abgabe nicht mit den mitgelieferten Maven Dateien kompiliert, führt das automatisch zum nicht bestehen der Hausarbeit.

### Maven Wrapper

Damit Sie keine weitere Software installieren müssen, liefern wir ein Wrapper Skript mit, mit welchem Maven automatisch heruntergeladen und installiert werden kann. Sollten Sie das Wrapper Skript verwenden, ersetzen sie ``mvn`` im Folgenden jeweils mit ``./mvnw`` unter Linux/Mac OS X oder ``mvnw.cmd`` unter Windows.

### Ausführen von Tests

```sh
mvn verify
```

Verify ohne weitere Parameter führt Tests für alle Unterprojekte auf. Wollen Sie nur einen Teil der Unterprojekte testen, können Sie dies folgendermaßen tun:

```sh
mvn verify -pl A001,B001,D001
```

### Kompilieren

Sie können Ihre Abgabe folgendermaßen kompilieren:
```sh
mvn build
```

Auch hier können Sie mit dem ``-pl`` Flag gezielt einzelne Unterprojekte bearbeiten.

Ausführen können Sie Ihr Programm danach beispielsweise von der Kommandozeile. Etwa für **B001**:

```sh
mvn clean build
cd B001/target/classes
java de/tubs/prog2/b001/graph/student/Main
```

### Erstellen von JARs

```sh
mvn package
```
Erstellt in jedem Unterprojekt einen target Ordner in welchem eine *.jar* Datei erzeugt wird, welche Sie ausführen können. Auch hier können Sie mit dem ``-pl`` Flag gezielt einzelne Unterprojekte bearbeiten. Standardmäßig blockieren fehlschlagende Tests das erzeugen von JAR files. Daher kann es unter Umständen sinnvoll sein, diese beim erstellen zu ignorieren:
```sh
mvn clean package -Dmaven.test.skip=true
```

#### Ausführen von main Methoden

Um Klassen mit main Methoden aus dem Jar auszuführen können Sie folgendermaßen vorgehen:
```sh
mvn clean package -Dmaven.test.skip=true -pl A001
java -cp A001/target/a001-1.0-SNAPSHOT.jar de.tubs.prog2.ex.provided.SecretCodes.Synth
```

Was die main Methode der Synth Klasse aus Teilprojekt A001 ausführt.

### Clean

Löscht alle vom Java Compiler erzeugten class files sowie JUnit Reports etc.

Wird folgendermaßen ausgeführt:
```sh
mvn clean
```

Die targets (*verify*, *clean*, etc) können kombiniert werden. Einem Aufruf von *verify* können Sie *clean* voranstellen, ala: ``mvn clean verify``. Das führt dazu das aller Quellcode sicher neu kompiliert wird.
