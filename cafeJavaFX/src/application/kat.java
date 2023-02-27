package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface kat {
		
		
		public Masa find_masa(String id);
		public void kat_masa_urun_ekle(String id,String urun_id);
		public String getKatAdi();
		public void setKatAdi(String katAdi);
		public String getKatID();
		public void MasaEkle(Masa masa);
		public void getMasalar();
		public float KatToplam();
		public void masa_toplam(String id);
		public void kat_masa_urun_sil(String id,String urun_id);
		//public void remove_m_urun(String masa_id,int urun_id);
		public List<Masa> getMasa();
		
	}

