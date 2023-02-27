package application;
import java.util.ArrayList;
import java.util.Map;



import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class Masa extends Urun{

	private float toplam = 0;
	private static int sonID = 0;
	private String id;
	private String MasaAdi;
	private List<Urun> m_urunler = new ArrayList<Urun>();
	private int kisi = 0;
	private int kisiFiyat=15;
	private Boolean isFull=false;
	
	Masa(){}
	
	Masa(String _MasaAdi) {
		MasaAdi = _MasaAdi;
		this.id = "M" + ++sonID;
		
	}

	
	protected float getToplam() {
		return toplam;
	}

	protected void setToplam(float toplam) {
		this.toplam = toplam;
	}

	protected void getUrunlerYaz() {
		for (Urun urun : m_urunler) {
			System.out.println(urun.getUrunadi());
		}
	}
	
	protected void setKisi(int _Kisi) {
		kisi=_Kisi;
	}

	protected String getMasaAd() {
		return this.MasaAdi;
	}

	protected void getUrunlerWithName() {
		Map<String, Integer> adetler = new HashMap<>();
		for (Urun urun : m_urunler) {
			String ad = urun.getUrunadi();
			if (!adetler.containsKey(ad)) {
				adetler.put(ad, 1);
			} else {
				int eskiAdet = adetler.get(ad);
				adetler.put(ad, eskiAdet + 1);
			}
		}

		for (String ad : adetler.keySet()) {
			System.out.println(ad + ": " + adetler.get(ad));
		}
	}
	protected int getVarOlanUrunSayi(String id) {
		int i=0;
		
		for(Urun urun: m_urunler) {
			if(urun.getUrun_id().equals(id)) {
				i++;
			}
		}
		return i;
		
	}

	protected void setUrun(String urun_id) {
		for(Urun str : urunler){
			if(str.getUrun_id().equals(urun_id)) {
				m_urunler.add(str);
			}
		}
	}
	
	protected List<Urun> getUrunlerList(){
		return m_urunler;
	}

	protected float getMasaTutar() {
		toplam = 0;
		for (Urun urun : m_urunler) {
			toplam += urun.getFiyat();
		}
		return toplam;
	}

	protected String getID() {
		return this.id;
	}
	
	protected void deleteUrunler() {
		m_urunler.clear();
	}
	
	
	protected void deleteUrun(String urun_id) {
		
		for (int i = 0; i < m_urunler.size(); i++) {
		  Urun urun = m_urunler.get(i);
		  if (urun.getUrun_id().equals(urun_id)) {
		    m_urunler.remove(i);
		    break;
		  }
		}  
	}
	protected void BirlestirMasa(Masa hedef) {
		if(this.getMasaTutar()!=0) {
		for(Urun urun:this.getUrunlerList()) {
			hedef.setUrun(urun.getUrun_id());
		}
		this.deleteUrunler();
		}
	}
	
	
	
	/*protected void combineMasa(Masa Eklenen) {
		for (Urun eklenen_urunler : Eklenen.getUrunlerList()) {
			this.setUrun(eklenen_urunler);
		}
		Eklenen.deleteUrunler();
		
	}
	*/
}
