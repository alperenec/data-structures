package odev3soru2;
import java.util.*; 
import java.text.Collator;
import java.util.Locale;

public class Hash {
	LinkedList<Eleman>[] bl;

    @SuppressWarnings("unchecked")
    public Hash() {
        bl = new LinkedList[29];
        for (int i = 0; i < 29; i++) {
            bl[i] = new LinkedList<Eleman>();
        }
    }

    public void ekle(Eleman eleman) {
        char ilkHarf = eleman.isim.toUpperCase(Locale.forLanguageTag("tr-TR")).charAt(0);
        int index = (int) ilkHarf - 'A';
        bl[index].addFirst(eleman);
    }

    public void sil(String isim) {
        char ilkHarf = isim.toUpperCase().charAt(0);
        int index = (int) ilkHarf - 'A';
        LinkedList<Eleman> liste = bl[index];

        for (Eleman eleman : liste) {
            if (eleman.isim.equals(isim)) {
                liste.remove(eleman);
                System.out.println("Eleman silindi: " + eleman.isim);
                return;
            }
        }

        System.out.println("Eleman bulunamadı: " + isim);
    }

    @SuppressWarnings("deprecation")
	public void listele() {
		Collator collator = Collator.getInstance(new Locale("tr", "TR"));

        for (char harf = 'A'; harf <= 'Z'; harf++) {
            int index = (int) harf - 'A';
            LinkedList<Eleman> liste = bl[index];

            Eleman[] elemanArray = liste.toArray(new Eleman[0]);

            // Türk alfabesine göre sıralama yap
            Arrays.sort(elemanArray, Comparator.comparing(e -> e.isim, collator));

            System.out.print(harf + " - -> ");
            for (Eleman eleman : elemanArray) {
                System.out.print(eleman.isim + " ");
            }
            System.out.println();
        }
    }

    public int elemanSayisi() {
        int toplam = 0;
        for (int i = 0; i < 29; i++) {
            toplam += bl[i].size();
        }
        return toplam;
    }

    public void harfeAitListele(char harf) {
        int index = (int) Character.toUpperCase(harf) - 'A';
        System.out.print(harf + " - -> ");
        LinkedList<Eleman> liste = bl[index];

        for (Eleman eleman : liste) {
            System.out.print(eleman.isim + " ");
        }
        System.out.println();
    }

    public int harfeAitElemanSayisi(char harf) {
        int index = (int) Character.toUpperCase(harf) - 'A';
        return bl[index].size();
    }
}
