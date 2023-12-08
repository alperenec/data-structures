package odev3soru2;

import java.util.Iterator;

import BagliListe_TekYonlu.LinkedList;
import BagliListe_TekYonlu.Node;

public class Eleman {
    String isim;
    String soyisim;
    int telno;

    Eleman(String isim, String soyisim, int telno) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.telno = telno;
    }
}

class ll extends LinkedList implements Iterable<Eleman> {
    public Iterator<Eleman> iterator() {
        return new ElemanIterator(this);
    }

    private static class ElemanIterator implements Iterator<Eleman> {
        private Node current;

        public ElemanIterator(ll list) {
            current = list.getFirst();
        }

        public boolean hasNext() {
            return current != null;
        }

        public Eleman next() {
            Eleman eleman = current.data;
            current = current.next;
            return eleman;
        }
    }

	public Node getFirst() {
		return null;
	}
}