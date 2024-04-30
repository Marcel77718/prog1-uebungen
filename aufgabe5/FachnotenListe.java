package aufgabe5;

import java.util.NoSuchElementException;

public class FachnotenListe {

    private Element head = null; // leere Liste

    /**
     * Fügt eine Zahl am Listenanfang ein.
     * Der heimliche Parameter this verweist auf das Objekt des Aufrufs.
     *
     * @param n die einzufügende Zahl
     * @return die Liste
     */
    public FachnotenListe insert(/* final IntList this, */ Fachnote n) {
        this.head = new Element(this.head, n);
        return this;
    }

    /**
     * Element speichert eine einzelne Zahl als Teil einer Liste.
     * Beispiel für eine statisch eingebettete Klasse.
     */
    private static final class Element {
        private final Element next;
        private final Fachnote n;

        private Element(/* final Element this, */ Element e, Fachnote n) {
            this.next = e;
            this.n = n;
        }
    }

    /**
     * Iterator speichert den aktuellen Zustand einer Listeniteration.
     * Beispiel für eine innere Klasse.
     */
    public final class Iterator {
        // private IntList IntList.this;
        private Element current = FachnotenListe.this.head;

        /**
         * prüft, ob das Listenende erreicht ist.
         * Der heimliche Parameter this verweist auf das Objekt des Aufrufs.
         *
         * @return false, wenn das Listenende erreicht ist, sonst true.
         */
        public boolean hasNext(/* final Iterator this */) {
            return this.current != null;
        }

        /**
         * liefert die aktuelle Zahl und iteriert zum nächsten Jahr.
         * Aufruf am Listenende liefert NoSuchElementException.
         * Der heimliche Parameter this verweist auf das Objekt des Aufrufs.
         *
         * @return die aktuelle Zahl
         */
        public Fachnote next(/* final Iterator this */) {
            if (this.current == null) {
                throw new NoSuchElementException();
            }

            Element e = this.current;
            this.current = this.current.next;
            return e.n;
        }
    }
}

