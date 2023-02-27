package application;

import java.util.ArrayList;
import java.util.List;


public class Urun{
	
	private static int son_id = 1;
	protected String urun_id;
	private float fiyat;
	private String Urunadi;
	static List<Urun> urunler = new ArrayList<Urun>();
	
	Urun(){}
	
	private Urun(String Urunad, float Fiyati) {
		this.Urunadi = Urunad;
		this.fiyat = Fiyati;
		urun_id ="U" + son_id;
		son_id++;
	}
	
	public void change_price(String id,float price) {	
		Urun verify_urun;
		for(int i = 0;i < urunler.size();i++) {
			verify_urun	= urunler.get(i);
			if(id.equals(verify_urun.urun_id)) {
				verify_urun.setFiyat(price);
			}
		}
	}
	
	
	public void change_name(String id,String new_name) {
		Urun verify_urun;
		for(int i = 0;i < urunler.size();i++) {
			verify_urun	= urunler.get(i);
			if(id.equals(verify_urun.urun_id)) {
				verify_urun.setUrunadi(new_name);
			}
		}
	}
	
	public void urun_add(String Urunadi,float fiyat) { 
		Urun urun = new Urun(Urunadi,fiyat);
		urunler.add(urun);
	}
	
	public void menu_list() {
	    for (Urun str : urunler)
	    { 		      
	         System.out.println(str.getUrunadi() + "   " + str.getFiyat()); 		
	    }
	}
	public List<Urun> getMenuList(){
		return urunler;
	}
	
	public float getFiyat() {
		return fiyat;
	}

	public void setFiyat(float fiyat) {
		this.fiyat = fiyat;
	}

	public String getUrunadi() {
		return Urunadi;
	}

	public void setUrunadi(String urunadi) {
		Urunadi = urunadi;
	}

	
	public String getUrun_id() {
		return urun_id;
	}
}
