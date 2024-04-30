// Klausurergebnis.java
package aufgabe4;
//import aufgabe4.schweiz.Noten;

import java.util.Locale;
import java.util.Scanner;


/**
 * Klausurergebnis erstellt eine Notenstatistik.
 * <p>
 * Das Programm liest Noten als Strings ein und bestimmt die beste und
 * die schlechteste Note, den Durchschnitt der Bestandenen sowie
 * die Durchfallquote in Prozent.
 * Das Programm berücksichtigt dabei nur die laut Noten.istZulaessig
 * erlaubten Noten. Andere Noten werden unter Ausgabe einer Warnung ignoriert.
 * Welche Noten besser und schlechter sind, welche als bestanden oder
 * durchgefallen gelten und wie die String-Darstellung der Noten aussieht,
 * wird mit Methoden der Klasse Noten bestimmt.
 * </p>
 * Das Programm gibt als Klausurergebnis folgende Werte aus:
 * <ul>
 * <li>die Anzahl der berücksichtigten Noten</li>
 * <li>die Anzahl der Bestandenen</li>
 * <li>die beste Note</li>
 * <li>die schlechteste Note</li>
 * <li>den Durchschnitt der Bestandenen</li>
 * <li>die Durchfallquote</li>
 * </ul>
 *
 * @author Marcel Friesen
 * @version 22.04.2024
 */

public final class Klausurergebnis {
    private Klausurergebnis() {
    }

    static int anzahlBeruecksichtigte = 0;
    static int bestanden = 0;
    static double beste = 1.0;
    static double schlechteste = 6.0;
    static double durchschnittSumme = 0.0;

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     *
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMAN);

        //--------------------------------------------------- Noten einlesen
        System.out.println("Noten im Format Ganze,Zehntel "
                + "oder Ganze.Zehntel eingeben (Ende mit Strg-D):");

        while (EINGABE.hasNext()) {
            String note = EINGABE.next();

            //---------------------------------------------- Eingabe prüfen

            /* TODO: (1) note prüfen ... */
            try {
                if (Noten.istZulaessig(note)) {
                    Noten.toString(Noten.toDouble(note));
                    {
                        anzahlBeruecksichtigte++;
                        beste = Noten.bessere(beste, Noten.toDouble(note));
                        schlechteste = Noten.schlechtere(schlechteste, Noten.toDouble(note));
                        if (Noten.istBestanden(Noten.toDouble(note))) {
                            bestanden++;
                            durchschnittSumme += Noten.toDouble(note);

                        }
                    }
                } else {
                    System.err.println("Unzulässige Note " + note + " wird ignoriert!");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Unzulässige Note " + note + " wird ignoriert!");
            }


            //------------------------------------------------ Note erfassen

            /* TODO: (2) Notensumme Bestandene, Anzahl Bestandene,
                         Anzahl Durchgefallene sowie
                         beste und schlechteste Note aktualisieren ... */

        } // while

        //------------------------------------------ Notenstatistik ausgeben

        /* TODO: (3) Durchschnitt und Durchfallquote berechnen
                     und dann die gesamte Statistik ausgeben ... */
        double durchschnittBestandene = durchschnittSumme / bestanden;
        double durchfallquote = ((anzahlBeruecksichtigte - bestanden) / (double) anzahlBeruecksichtigte) * 100;

        System.out.println("Anzahl Beruecksichtigter Noten:  " + anzahlBeruecksichtigte);
        System.out.println("Anzahl Bestandene: " + bestanden);
        System.out.println("Beste Note: " + schlechteste);
        System.out.println("Schlechteste Note:  " + beste);
        System.out.printf("Durchschnitt Bestandene: %.1f%n", durchschnittBestandene);
        System.out.printf("Durchfallquote: %.1f%%%n", durchfallquote);

    } // main
}

