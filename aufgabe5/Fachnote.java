package aufgabe5;

public class Fachnote {
    public static String fach;
    public static Note note;

    public Fachnote(String fach, Note note) {
        if (fach == null || note == null || fach.isEmpty()) {
            throw new IllegalArgumentException("fach is null or empty");
        } else {
            this.fach = fach;
            this.note = note;

        }
    }
}
