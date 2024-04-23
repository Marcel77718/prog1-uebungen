// Notenstatistik.java
package aufgabe3;

import java.util.Locale;
import java.util.Scanner;

/**
 * erstellt eine Notenstatistik.
 * <p>
 * Das Programm erwartet Pr&uuml;fungsnoten im Format
 * <code>Ganze,Zehntel</code> oder <code>Ganze.Zehntel</code>,
 * wobei <code>Ganze</code> und <code>Zehntel</code> nur aus
 * je einer Dezimalziffer bestehen d&uuml;rfen.
 * Andere Eingaben werden wegen Formatfehler ignoriert.
 * </p>
 * <p>
 * Das Programm gibt die folgende Statistik aus:
 * </p>
 * <ul>
 * <li>die Anzahl der ber&uuml;cksichtigten Noten</li>
 * <li>die Anzahl der Bestandenen</li>
 * <li>die beste Note</li>
 * <li>die schlechteste Note</li>
 * <li>den Durchschnitt der Bestandenen</li>
 * <li>die Durchfallquote in Prozent</li>
 * </ul>
 * <p>
 * Es werden in der Statistik nur die nach HTWG-Pr&uuml;fungsordnung
 * zul&auml;ssigen Noten (1,0 1,3 1,7 2,0 2,3 2,7 3,0 3,3 3,7 4,0 5,0)
 * ber&uuml;cksichtigt.
 * Andere Eingaben werden wegen falscher Vorkommastelle oder
 * falscher Nachkommastelle ignoriert.
 * Alle Noten bis 4,0 gelten als bestanden, nur die 5,0 als durchgefallen.
 * </p>
 *
 * @author Dominik Stich
 * @version 15.11.2023
 */
public final class Notenstatistik {
    private Notenstatistik() {
    }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     *
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMANY);

        // --------------------------------------------------- Noten einlesen
        System.out.println("Noten im Format Ganze,Zehntel "
                + "oder Ganze.Zehntel eingeben (Ende mit Strg-D):");

        int anzahl = 0;
        int bestanden = 0;
        double beste = 6.0;
        double schlechteste = 0.0;
        double durchschnitt = 0.0;
        double durchfallquote = 0.0;

        while (EINGABE.hasNext()) {
            String note = EINGABE.next();
            double ergebnis = 0;

            if (note.length() == 3) {
                char vorkomma = note.charAt(0);
                char komma = note.charAt(1);
                char nachkomma = note.charAt(2);

                if ((komma == ',' || komma == '.')
                        && Character.isDigit(nachkomma)
                        && Character.isDigit(vorkomma)) {

                    if (Character.getNumericValue(vorkomma) >= 1
                            && Character.getNumericValue(vorkomma) <= 5) {
                        switch (Character.getNumericValue(nachkomma)) {
                        case 0:
                        case 3:
                        case 7:
                            // ---------------------------------- Note erfassen
                            note = vorkomma + "." + nachkomma;
                            ergebnis = Double.parseDouble(note);

                            if (ergebnis > 4 && ergebnis < 5
                                || ergebnis > 5) {
                                System.out.printf("Note %c%c%c wird wegen "
                                        + "Nachkommastelle %c ignoriert!%n",
                                        vorkomma, komma, nachkomma,
                                        nachkomma);
                                ergebnis = 0;
                            } else {
                                anzahl++;
                            }
                            break;
                        default:
                            System.out.printf("Note %s wird wegen "
                                    + "Nachkommastelle %c ignoriert!%n", note,
                                    nachkomma);
                            break;
                        }
                    } else {
                        System.out.printf("Note %s wird wegen Vorkommastelle"
                                + " %s ignoriert!%n", note, vorkomma);
                    }
                } else {
                    System.out.printf("Note %s wird wegen Formatfehler"
                            + " ignoriert!%n", note);
                }
            } else {
                System.out.printf("Note %s wird wegen Formatfehler"
                        + " ignoriert!%n", note);
            }

            if (ergebnis > 0) {

                durchschnitt += ergebnis <= 4.0 ? ergebnis : 0;
                bestanden += ergebnis <= 4.0 ? 1 : 0;
                beste = beste > ergebnis ? ergebnis : beste;
                schlechteste = schlechteste < ergebnis ? ergebnis
                        : schlechteste;
            }
        }


        durchschnitt /= bestanden;
        durchfallquote = ((anzahl - bestanden) / (double) anzahl) * 100.0;

        System.out.printf("%nAnzahl beruecksichtigter Noten: %d%n", anzahl);
        System.out.printf("Anzahl Bestandene: %d%n", bestanden);
        if (anzahl > 0) {
            System.out.printf("Beste Note: %.1f%n", beste);
            System.out.printf("Schlechteste Note: %.1f%n", schlechteste);
            System.out.printf("Durchschnitt Bestandene: %.1f%n", durchschnitt);
            System.out.printf("Durchfallquote: %.1f%%%n", durchfallquote);
        }
    }
}