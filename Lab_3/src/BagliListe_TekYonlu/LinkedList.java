package BagliListe_TekYonlu;

public class LinkedList {
	Node head;
	Node tail;
	
	public LinkedList(){
		head=null;
		tail=null;
	}

	void basaEkle(Node yeni) {
		if(head==null) {
			head=yeni;
			tail=yeni;
		}
		else {
			yeni.next=head;
			head=yeni;
			
		}
		Yazdir();
		
	}
	
	void bastanSil() {
	    if (head == null) {
	        System.out.println("Liste boş, silme işlemi yapılamaz.");
	        return;
	    }

	    // Head'i bir sonraki elemana kaydır
	    head = head.next;

	    // Eğer listenin son elemanını siliyorsak, tail'i de güncelle
	    if (head == null) {
	        tail = null;
	    }

	    Yazdir();
	}
	
	void sonaEkle(Node yeni) {
	    if (head == null) {
	        // Liste boşsa, başa ekleme ile aynı işlemleri gerçekleştir
	        head = yeni;
	        tail = yeni;
	    } else {
	        // Liste boş değilse, yeni elemanı listenin sonuna ekle
	        tail.next = yeni;
	        tail = yeni;
	    }
	    Yazdir();
	}
	
	void sondanSil() {
	    if (head == null) {
	        System.out.println("Liste boş, silme işlemi yapılamaz.");
	        return;
	    }

	    // Eğer liste sadece bir eleman içeriyorsa, head ve tail'i null yaparak listeyi boşalt
	    if (head == tail) {
	        head = tail = null;
	        Yazdir();
	        return;
	    }

	    // Listenin sonundan bir önceki elemanı bul
	    Node current = head;
	    while (current.next != tail) {
	        current = current.next;
	    }

	    // Tail'i güncelle, son elemanı listeden çıkar
	    current.next = null;
	    tail = current;

	    Yazdir();
	}
	
	void elemanAra(int dt) {
	    Node current = head;

	    while (current != null && current.dt != dt) {
	        current = current.next;
	    }

	    if (current == null) {
	        System.out.println("Belirtilen dogum tarihine sahip eleman bulunamadı.");
	    } else {
	        System.out.println("Bulunan Elemanın Bilgileri:"+"  Ad: " + current.ad+"  Tckn: " + current.tckn+ "  Dogum Tarihi: " + current.dt);


	        // Silme işlemi yerine sadece bilgileri getiriyoruz, bu nedenle Yazdir() fonksiyonunu çağırmıyoruz.
	    }
	}
	
	void belirliSırayaEkle(int sira, Node yeni) {
	    if (sira < 0) {
	        System.out.println("Geçersiz sıra.");
	        return;
	    }

	    if (sira == 0) {
	        basaEkle(yeni);
	    } else {
	        Node current = head;
	        int currentIndex = 0;

	        // Belirtilen sıraya kadar ilerle
	        while (current != null && currentIndex < sira - 1) {
	            current = current.next;
	            currentIndex++;
	        }

	        if (current == null) {
	            System.out.println("Belirtilen sıra bulunamadı.");
	            return;
	        }

	        // Yeni elemanın next referansını belirtilen sıradaki elemanın next referansına ayarla
	        yeni.next = current.next;

	        // Belirtilen sıradaki elemanın next referansını yeni elemana ayarla
	        current.next = yeni;

	        // Eğer eklenen eleman listenin sonuna ekleniyorsa, tail'i güncelle
	        if (current == tail) {
	            tail = yeni;
	        }
	    }

	    Yazdir();
	}
	
	void Yazdir() {
		Node tmp=head;
		while (tmp!=null) {
			System.out.println("kişinin adı: " + tmp.ad + "  kişinin tcno'su: " + tmp.tckn + "  kişinin doğum tarihi: " + tmp.dt);
			tmp=tmp.next;
		}
		System.out.println("*******************************************************************************");
		
	}
	
}
