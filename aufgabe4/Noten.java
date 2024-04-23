package aufgabe4;

public class Noten {

    public static double BESTE;
    public static double SCHLECHTESTE;


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
            return Double.parseDouble(note);
    } else {
            throw new IllegalArgumentException("ungültige Zahl");
        }
    }
}

