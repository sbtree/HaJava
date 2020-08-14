package de.tubs.prog2.ex.provided.SecretCodes;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiChannel;

/**
 * https://gist.github.com/pbloem/d29bf80e69d333415622 mit Aenderungen
 */
public class Synth {

    private static final List<String> NOTES = Arrays.asList("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B");
    private static final Map<String, String> NOTE_MAP = Map.of(
            "0", "4C",
            "1", "4D",
            "2", "4E",
            "3", "4F",
            "4", "4G",
            "5", "4A",
            "6", "4B",
            "7", "5C",
            "8", "5D",
            "9", "5E");
    private static MidiChannel[] channels;
    private static final int VOLUME = 50; // zwischen 0 und 127

    private final Synthesizer synth;

    /**
     * Erzeugt einen neuen Synthesizer
     * @throws MidiUnavailableException Wenn es nicht möglich ist Sound auszugeben
     */
    public Synth() throws MidiUnavailableException {
        // Öffne einen Synthesizer
        synth = MidiSystem.getSynthesizer();
        synth.open();
        channels = synth.getChannels();
    }

    /**
     * Schaltet den Synthesizer aus
     */
    public void close() {
        synth.close();
    }

    /**
     * Spielt eine Note für einen Schlüssel für eine Sekunde
     * @param schluessel Geheimschlüssel
     * @throws InterruptedException Thrown when the Thread is interrupted
     */
    public void tone(String schluessel) throws InterruptedException {
        String note = NOTE_MAP.get(schluessel);
        play(note,  1000);
    }

    /**
     * Spielt eine Note für einen Schlüssel für einen Zeitraum
     * @param schluessel Geheimschlüssel
     * @param duration Dauer
     * @throws InterruptedException Thrown when the Thread is interrupted
     */
    public void tone(String schluessel, int duration) throws InterruptedException {
        String note = NOTE_MAP.get(schluessel);
        play(note,  duration);
    }

    /**
     * Spielt eine Note für einen Zeitraum
     * @param note Note
     * @param duration Dauer
     * @throws InterruptedException Thrown when the Thread is interrupted
     */
    private void play(String note, int duration) throws InterruptedException {
        Thread.sleep(10);
        channels[0].noteOn(id(note), VOLUME );
        Thread.sleep(duration);
        channels[0].noteOff(id(note));
    }

    /**
     * Erhalte die MIDI id für einen Ton: z.B. 4C -> 60
     * @return midi id
     */
    private int id(String note) {
        int octave = Integer.parseInt(note.substring(0, 1));
        return NOTES.indexOf(note.substring(1)) + 12 * octave + 12;
    }

    public static void main(String[] args) {
        try {
            Synth synth = new Synth();
            synth.tone("0");
            synth.tone("1");
            synth.tone("2");
            synth.tone("3");
            synth.tone("4");
            synth.tone("5");
            synth.tone("6");
            synth.tone("7");
            synth.tone("8");
            synth.tone("9");
            synth.close();
        } catch (MidiUnavailableException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}