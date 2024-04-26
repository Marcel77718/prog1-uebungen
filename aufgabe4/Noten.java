package aufgabe4;

public class Noten {

    public static double BESTE = 1.0;
    public static double SCHLECHTESTE = 5.0;


    public static boolean istZulaessig(String note) {

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
                            return true;
                        default:
                    }
                }
            }
        }
        return false;
    }

    public static double toDouble(String note) {

        if (istZulaessig(note)) {
            return Double.parseDouble(note.replace(',','.'));
        }
                throw new IllegalArgumentException("Unzulässige Note: " + note + " wird ignoriert!");
    }

    public static String toString(double note) {

        if (note >= BESTE && note <= SCHLECHTESTE || note == 5.0) {
            return String.format("%.1f", note);
        }
            throw new IllegalArgumentException("Unzulässige Note: " + note + " wird ignoriert! :(");
    }

    public static boolean istBestanden(double note) {
        return note <= 4.0;
    }

    public static double bessere(double note1, double note2) {
        return note1 < note2 ? note2 : note1;
    }


    public static double schlechtere(double note1, double note2) {
        return note1 < note2 ? note1 : note2;
    }
}

