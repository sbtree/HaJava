package de.tubs.prog2.ex;

import de.tubs.prog2.ex.students.Gegenstand.HermineanRucksack;
import de.tubs.prog2.ex.provided.Gegenstand.MauerGegenstand;
import de.tubs.prog2.ex.students.Gegenstand.RonaldeanRucksack;
import de.tubs.prog2.ex.students.Gegenstand.ZauberRucksack;
import de.tubs.prog2.ex.provided.Mauer.Mauer;
import de.tubs.prog2.ex.students.SecretCodes.ToneSecretCodeGenerator;
import de.tubs.prog2.ex.students.SecretCodes.IntegerSecretCodeGenerator;
import de.tubs.prog2.ex.provided.SecretCodes.SecretCodeGenerator;
import de.tubs.prog2.ex.provided.Suchstrategie.SuchStrategie;
import de.tubs.prog2.ex.students.Suchstrategie.MeineSuche;
import de.tubs.prog2.ex.students.Wanderer.HermineWanderer;
import de.tubs.prog2.ex.provided.Wanderer.StandardWanderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class TestMauer {
//    @Test
//    @Order(1)
//    void test() {
//
//        SecretCodeGenerator secretCodeGenerator = new IntegerSecretCodeGenerator();
//        Mauer mauer = new Mauer(16, secretCodeGenerator, 101);
//
//        assertFalse(mauer.ueberpruefeTor(1));
//        assertEquals("0", mauer.erhalteMauerSecretCodeStueck(1).getSchluessel());
//        assertFalse(mauer.ueberpruefeTor(2));
//        assertEquals("3", mauer.erhalteMauerSecretCodeStueck(1).getSchluessel());
//
//        try {
//            mauer.ueberpruefeTor(12);
//            fail();
//        } catch (Exception e) {
//            // all right. Die Schrittweite ist 1. Nicht moeglich herumzuspringen.
//        }
//    }

//    @Test
//    @Order(2)
//    void testSuche() {
//        SecretCodeGenerator secretCodeGenerator = new IntegerSecretCodeGenerator();
//        StandardWanderer wanderer = new HermineWanderer(100000);
//
//        Mauer mauer = new Mauer(128, secretCodeGenerator, 10);
//        SuchStrategie suchStrategie = new MeineSuche(mauer, wanderer);
//        suchStrategie.starteSuche();
//
//        assertTrue(mauer.isTorZugriffErlaubt());
//        assertEquals(128, wanderer.getPosition());
//    }

//    @Test
//    @Order(3)
//    void testSuche2() {
//        SecretCodeGenerator secretCodeGenerator = new IntegerSecretCodeGenerator();
//        StandardWanderer wanderer = new HermineWanderer(4);
//
//        Mauer mauer = new Mauer(256, secretCodeGenerator, 10);
//        SuchStrategie suchStrategie = new MeineSuche(mauer, wanderer);
//        suchStrategie.starteSuche();
//
//        // Hier sollte es fehlschlagen, da nur 4 Schritte erlaubt waren. Das ist hier nicht moeglich zu schaffen.
//        assertFalse(mauer.isTorZugriffErlaubt());
//    }

//    @Test
//    @Order(4)
//    void testRucksack() {
//        MauerGegenstand g1 = new MauerGegenstand(5);
//        MauerGegenstand g2 = new MauerGegenstand(15);
//
//        ZauberRucksack<MauerGegenstand> z1 = new RonaldeanRucksack<MauerGegenstand>(5);
//
//        z1.inRucksackAblegen(g1);
//        z1.inRucksackAblegen(g2);
//
//        List<MauerGegenstand> resultat = z1.allesRausholen();
//        assertEquals(2, resultat.size());
//        assertEquals(15, resultat.get(0).getWert());
//        assertEquals(5, resultat.get(1).getWert());
//    }

//    @Test
//    @Order(5)
//    void testRucksack2() {
//        MauerGegenstand g1 = new MauerGegenstand(100);
//        MauerGegenstand g2 = new MauerGegenstand(200);
//
//        ZauberRucksack<MauerGegenstand> z2 = new HermineanRucksack<MauerGegenstand>();
//
//        z2.inRucksackAblegen(g1);
//        z2.inRucksackAblegen(g2);
//
//        List<MauerGegenstand> resultat = z2.allesRausholen();
//        assertEquals(2, resultat.size());
//        assertEquals(200, resultat.get(0).getWert());
//        assertEquals(100, resultat.get(1).getWert());
//    }

//    @Test
//    @Order(6)
//    void testSucheMitTon() {
//        SecretCodeGenerator secretCodeGenerator = new ToneSecretCodeGenerator();
//        StandardWanderer wanderer = new HermineWanderer(10000);
//
//        Mauer mauer = new Mauer(32, secretCodeGenerator, 10);
//        SuchStrategie suchStrategie = new MeineSuche(mauer, wanderer);
//        suchStrategie.starteSuche();
//
//        assertTrue(mauer.isTorZugriffErlaubt());
//    }
}
