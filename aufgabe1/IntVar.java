// IntVar.java

package aufgabe1;

import java.util.Scanner;

/**
 * IntVar zeigt den Umgang mit Variablen vom Typ int.
 * &Uuml;bungsaufgabe 1 zur Programmiertechnik 1.
 * @author Marcel Friesen
 * @version 27.10.2023
 */
public final class IntVar {
    private IntVar() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        final int min = 0x80000000;
        final int max = 0x7FFFFFFF;


        System.out.println("1. Zahl:");
        System.out.println("2. Zahl:");


        int zahl1 = EINGABE.nextInt();
        int zahl2 = EINGABE.nextInt();


        System.out.printf("%d ist oktal %o und hexadezimal %x%n",
                zahl1, zahl1, zahl1);

        System.out.printf("%d ist oktal %o und hexadezimal %x%n",
                zahl2, zahl2, zahl2);


        System.out.printf("%d + %d ist %d%n", zahl1, zahl2, zahl1 + zahl2);
        System.out.printf("%d - %d ist %d%n", zahl1, zahl2, zahl1 - zahl2);
        System.out.printf("%d * %d ist %d%n", zahl1, zahl2, zahl1 * zahl2);
        System.out.printf("%d / %d ist %d%n", zahl1, zahl2, zahl1 / zahl2);
        System.out.printf("%d %% %d ist %d%n", zahl1, zahl2, zahl1 % zahl2);


        System.out.printf("%d == %d ist %b%n", zahl1, zahl2, zahl1 == zahl2);
        System.out.printf("%d != %d ist %b%n", zahl1, zahl2, zahl1 != zahl2);
        System.out.printf("%d < %d ist %b%n", zahl1, zahl2, zahl1 < zahl2);
        System.out.printf("%d <= %d ist %b%n", zahl1, zahl2, zahl1 <= zahl2);
        System.out.printf("%d > %d ist %b%n", zahl1, zahl2, zahl1 > zahl2);
        System.out.printf("%d >= %d ist %b%n", zahl1, zahl2, zahl1 >= zahl2);
    }
}

