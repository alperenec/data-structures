package BagliListe_TekYonlu;

import odev3soru2.Eleman;

public class Node {
	int tckn;
	String ad;
	int dt;
	public Node next;
	public Eleman data;
	
	Node(int tckn, String ad, int dt){
		this.ad=ad;
		this.dt=dt;
		this.tckn=tckn;
		next=null;
	}
}
