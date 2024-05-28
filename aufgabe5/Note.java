package aufgabe5;

import java.util.Objects;

public final class Note {

    private final int note;

    private Note(int note) {
        this.note = note;
    }

    public static final Note BESTE = new Note(1);
    public static final Note SCHLECHTESTE = new Note(5);

    public static Note valueOf(int wert) {
        return switch (wert) {
            case 10, 13, 17, 20, 23, 27, 30, 33, 37, 40, 50 -> new Note(wert);
            default -> throw new IllegalArgumentException("unzulässige Note: " + wert);
        };
    }

    public static Note valueOf(String wert) {
        wert = wert.replace(',', '.');
        switch (wert) {
            case "1.0":
            case "1.3":
            case "1.7":
            case "2.0":
            case "2.3":
            case "2.7":
            case "3.0":
            case "3.3":
            case "3.7":
            case "4.0":
            case "5.0":
                return new Note((int) Double.parseDouble(wert) * 10);
            default:
                throw new IllegalArgumentException("unzulässige Note: " + wert);
        }
    }


    public int intValue() {
        return note;
    }

    public boolean istBestanden() {
        return note <= 40;
    }

    @Override
    public String toString() {
        return ("" + (note / 10.0)).replace('.', ',');
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Note ) {
            Note n = (Note) o;
            return note == n.intValue();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return note;
    }
}
