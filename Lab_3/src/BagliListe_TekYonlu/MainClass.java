//derste yaptık basa ekleme tamam

package BagliListe_TekYonlu;

public class MainClass {

	public static void main(String[] args) {

		LinkedList bl=new LinkedList();
		Node el=new Node(24255424, "alperen",2003);
		Node el1=new Node(7789788,"yusuf",1888);
		Node el2=new Node(64648,"akif",1965);
		Node el3=new Node(32348,"ilman",1974);
		
		
		bl.basaEkle(el);
		bl.basaEkle(el1);
		bl.sonaEkle(el2);
		bl.belirliSırayaEkle(1,el3);
		bl.bastanSil();
		bl.sondanSil();
		bl.elemanAra(1974);
		
	}

}
