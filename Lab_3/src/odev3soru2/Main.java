package odev3soru2;

public class Main {

	 public static void main(String[] args) {
	        Hash hashTable = new Hash();

	        hashTable.ekle(new Eleman("David", "Veli", 123));
	        hashTable.ekle(new Eleman("Arthur", "Pendragon", 456));
	        hashTable.ekle(new Eleman("Adam", "Demir", 789));
	        hashTable.ekle(new Eleman("Beth", "Yılmaz", 987));
	        hashTable.ekle(new Eleman("William", "Durmaz", 5645));
	        hashTable.ekle(new Eleman("Morgana", "Candan", 2003));
	        hashTable.ekle(new Eleman("hanna", "montana", 1787));
	        hashTable.ekle(new Eleman("Astrid", "Yılmaz", 9000));
	        hashTable.ekle(new Eleman("Harold", "Finch", 9000));
	        hashTable.ekle(new Eleman("Aemon", "Targaryen", 9000));
	        hashTable.ekle(new Eleman("Daenareys", "Targaryen", 9000));

	        hashTable.harfeAitListele('A');
	        System.out.println("Eleman Sayısı: " + hashTable.elemanSayisi());

	        hashTable.sil("Ceyda");

	        hashTable.listele();
	        System.out.println("Eleman Sayısı: " + hashTable.elemanSayisi());

	        hashTable.harfeAitListele('A');
	        System.out.println("A Harfine Ait Eleman Sayısı: " + hashTable.harfeAitElemanSayisi('A'));
	    }

}
