package aufgabe5;

import java.util.Objects;

public class Note {

    private final int note;

    private Note(int note) {
        this.note = note;
    }

    public static final Note BESTE = new Note(1);
    public static final Note SCHLECHTESTE = new Note(5);

    public static Note valueOf(int note) {
        return switch (note) {
            case 10, 13, 17, 20, 23, 27, 30, 33, 37, 40, 50 -> new Note(note);
            default -> throw new IllegalArgumentException("unzulässige Note: " + note);
        };
    }

    public static void valueOf(String note) {
        if (!(Objects.equals(note, String.format("%d,0", Integer.parseInt(note))))) {
            throw new IllegalArgumentException("unzulässige Note: " + note);
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
        return String.format("%d,0", note);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Note other) {
            return note == other.note;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return note;
    }
}
