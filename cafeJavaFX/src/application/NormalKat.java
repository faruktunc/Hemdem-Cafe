package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NormalKat implements kat{
	public static int sonID=0;
	public List<Masa> masalar=new ArrayList<>();
	public String ID;
	public static String KatAdi;
	
	NormalKat(String name){
		this.setKatAdi(name);
		this.ID="K" + ++sonID;
	}
	
	@Override
	public String getKatAdi() {
		return KatAdi;
	}
	
	@Override
	public void setKatAdi(String katAdi) {
		KatAdi = katAdi;
		
	}
	
	@Override
	public String getKatID() {
		return ID;
	}
	
	@Override
	public void MasaEkle(Masa masa) {
	masalar.add(masa);	
	}
	@Override
	public List<Masa> getMasa() {
		return masalar;
	}
	
	@Override
	public void getMasalar() {
		Map<String, Integer> adetler = new HashMap<>();
	    for (Masa masa : masalar) {
	      String ad = masa.getID();
	      if (!adetler.containsKey(ad)) {
	        adetler.put(ad, 1);
	      } else {
	        int eskiAdet = adetler.get(ad);
	        adetler.put(ad, eskiAdet + 1);
	      }
	    }

	    for (String ad : adetler.keySet()) {
	      System.out.println(ad + ": " + find_masa(ad).getMasaTutar());
	    }
	}
	
	@Override
	public float KatToplam() {
		float toplam=0;
		for (Masa masa : masalar) {
			toplam+=masa.getMasaTutar();
		}
		return toplam;
		}

	
	
	@Override
	public Masa find_masa(String id) {
		for(Masa str : masalar) {
			if(str.getID().equals(id)) {
				return str;
			}
		}
		return null;
	}

	
	@Override
	public void kat_masa_urun_ekle(String id, String urun_id) {
		Masa y_masa = find_masa(id);
		y_masa.setUrun(urun_id);
		
		
	}

	
	
	@Override
	public void masa_toplam(String m_id) {
	for(Masa str : masalar){
		if(str.getID().equals(m_id)) {
			System.out.println(str.getMasaAd() + "Toplam Tutar: " + str.getMasaTutar());
		}
	}
	}
	/*
	public void remove_m_urun(String masa_id,int urun_id) {
		for(Masa str : masalar) {
			if(str.getID().equals(masa_id)){
			str.deleteUrun(urun_id);
			}
		}
	}
  */

	@Override
	public void kat_masa_urun_sil(String id, String urun_id) {
		Masa target=find_masa(id);
		target.deleteUrun(urun_id);
		
	}
}
