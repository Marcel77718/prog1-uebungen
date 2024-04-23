// Histogramm.java
package aufgabe2;

import java.util.Scanner;

/**
 * Histogramm liest ganze Zahlen zwischen 1 und 6 ein und
 * gibt deren H&auml;ufigkeitsverteilung als Histogramm aus.
 * @author Marcel Friesen
 * @version 12.11.2023
 */
public final class Histogramm {
    private Histogramm() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {

        int[] zaehler = {0, 0, 0, 0, 0, 0};

        final int doller = 5;


        System.out.println("Ganze Zahlen zwischen 1 und 6 eingeben "
                    + "(Ende mit Strg-D/Strg-Z):");

        while (EINGABE.hasNextInt()) {
            int number = EINGABE.nextInt();

            if (number >= 1 && number <= zaehler.length) {
                zaehler[number - 1]++;
            } else {
                System.out.println("Falsche Eingabe wird ignoriert: " + number);
            }
        }



        System.out.println("Histogramm: ");

        for (int i = 0; i < zaehler.length; i++) {
            for (int j = 1; j <= zaehler[i]; j++) {
                if (j % doller == 0) {
                    System.out.print("$");
                } else {
                    System.out.print(i + 1);
                }
            }

            System.out.printf(" (%d) %n", zaehler[i]);
        }
    }
}

