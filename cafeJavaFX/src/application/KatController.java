package application;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class KatController {
	static kat kat_1=null;
	static kat kat_2=null;
	static kat kat_3=null;
	static Urun menu_1=null;
	public static void Cafe() {
		 menu_1 = new Urun();
		 kat_1 = new NormalKat("Normal_kat");
		 kat_2= new NormalKat("Deneme kat2");
		 kat_3=new NormalKat("Test Kat3");
		menu_1.urun_add("Lahmacun", 15);
		menu_1.urun_add("meyve tabağı", 20);
		menu_1.urun_add("Meze", 60);
		menu_1.urun_add("Tekila", 135);
		menu_1.urun_add("çay", 5);
		kat_1.MasaEkle(new Masa("masa_1"));
		kat_1.MasaEkle(new Masa("masa_2"));
		kat_2.MasaEkle(new Masa("masa_2.1"));
		kat_2.MasaEkle(new Masa("masa_2.2"));
		kat_2.MasaEkle(new Masa("masa_2.3"));
		kat_2.MasaEkle(new Masa("masa_2.4"));
		kat_1.kat_masa_urun_ekle("M1", "U1");
		kat_1.kat_masa_urun_ekle("M1", "U2");
		kat_1.kat_masa_urun_ekle("M2", "U1");
		kat_2.kat_masa_urun_ekle("M3", "U2");
		kat_3.MasaEkle(new Masa("masa_3.1"));
		
	}
	 @FXML
	private BorderPane ANASAYFA;
    @FXML
    private Button Buton1;
    @FXML
    private Button KAT3;

    @FXML
    private Button Kat2;
    @FXML
    private HBox MasaHBOX;
    @FXML
    private Pane KatToplamPane;
    @FXML
    private Label KatToplamLabel;

   
    public static List<Button> Butonlist=new ArrayList<>();

    @FXML
    public void Gecis(ActionEvent event) {
    	if (event.getSource()==Buton1) {
    		System.out.println("Kat 1 goruntuleniyor");
    		MasaBilgiler.KatNosu="1.";
			goruntule(kat_1);
		}
    	else if(event.getSource()==KAT3) {
    		System.out.println("Kat 3 goruntuleniyor");
    		MasaBilgiler.KatNosu="3.";
    		goruntule(kat_3);
    	}
    	else if(event.getSource()==Kat2) {
    		System.out.println("Kat 2 goruntuleniyor");
    		MasaBilgiler.KatNosu="2.";
    		goruntule(kat_2);
    	}
    }
    public void goruntule(kat goruntulenecek) {
    	if(goruntulenecek!=null) {
    	List<Masa> masaListesi=goruntulenecek.getMasa();
    	GridPane katGoruntu=new GridPane();
    	katGoruntu.setHgap(10);
    	katGoruntu.setVgap(10);
   for (int i = 0; i < masaListesi.size(); i++) {
	   Masa target=masaListesi.get(i);
	   Button buton=new Button(target.getID());
	   buton.setPrefHeight(100);
	   buton.setPrefWidth(50);
	   katGoruntu.add(buton, i%3, i/3);
	   Butonlist.add(buton);
}
   		//katGoruntu.setGridLinesVisible(true);
   		katGoruntu.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
   		ANASAYFA.setCenter(katGoruntu);
   		KatToplamLabel.setText("Toplam Kat Tutarı: "+goruntulenecek.KatToplam()+" ₺");
   		//KatToplamPane.getChildren().add(KatToplamLabel);
   			masaGoruntule();
    	}
}
    /* Masa Controller Kısmı*/
    

 public void masaGoruntule() {
	  	for (Button button : Butonlist) {
	  		
				button.setOnAction(e-> {
					
					System.out.println(button.getText()+" Masasina Tiklandi");
					
					if (kat_1.find_masa(button.getText())!=null) {
						MasaBilgiler.masa=kat_1.find_masa(button.getText());	
					} 
					else if(kat_2.find_masa(button.getText())!=null) {
						MasaBilgiler.masa=kat_2.find_masa(button.getText());	
					}
					else if(kat_3.find_masa(button.getText())!=null) {
						MasaBilgiler.masa=kat_3.find_masa(button.getText());	
					}
					

					Parent root = null;
					try {
						FXMLLoader fxmlmimiz= new FXMLLoader(getClass().getResource("Masa.fxml"));
						root=fxmlmimiz.load();
						
					} catch (IOException a) {
						a.printStackTrace();
					}
					
					
					Scene sahne=new Scene(root);
					Stage newWindow = new Stage();
					newWindow.setResizable(false);
					newWindow.setScene(sahne);
					newWindow.initModality(Modality.APPLICATION_MODAL);
					newWindow.show();
				});
			}
	  	
 }

}



