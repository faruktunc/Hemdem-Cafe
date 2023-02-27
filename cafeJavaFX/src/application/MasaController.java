package application;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MasaController {
	public Masa masamiz=null;
    @FXML
    private Spinner<Integer> AdetSpinner;

    @FXML
    private Label KatNoLBL;

    @FXML
    private Button MasaBirlesButon;

    @FXML
    private Label MasaNoLBL;

    @FXML
    private Label MasaTopLBL;

    @FXML
    private Button OdemeAlButon;

    @FXML
    private ComboBox<String> UrunlerCombo;

    @FXML
    private Button UrunuEkleButon;
    @FXML
    private Spinner<Integer> SeciliUrunAdet;

    @FXML
    private Button SeciliUrunButton;

    @FXML
    private ComboBox<String> SeciliUrunCombo;
    public void initialize() {
    	
       DisplayMasa();
       DisplayUrunListe();
       DisplaySpinner();
       EkleUrunu();
       OdemeAl();
       DisplayVarUrun();
       DisplaySeciliSpinner();
       SeciliUrunOde();
       MasaBirlestir();
    }
    public void DisplayMasa() {
    	masamiz=MasaBilgiler.masa;
    	KatNoLBL.setText(MasaBilgiler.KatNosu);
    	MasaNoLBL.setText(MasaBilgiler.masa.getID());
    	MasaTopLBL.setText(MasaBilgiler.masa.getMasaTutar()+"₺");
    	
    }
    public void DisplayUrunListe() {
    	for (Urun urun : KatController.menu_1.getMenuList()) {
			UrunlerCombo.getItems().add((urun.getUrun_id()+":"+urun.getUrunadi()+"  "+urun.getFiyat()+"₺"));
		}	
    }
    public void DisplaySpinner() {
    	AdetSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1,1));
    }
    
    
    
    public void EkleUrunu() {
    	UrunuEkleButon.setOnAction(e->{
    		String secim=UrunlerCombo.getValue();
    		String seciminID=secim.substring(0, secim.indexOf(":"));
    		
    		for(int i=1;i<=AdetSpinner.getValue();i++)
    		MasaBilgiler.masa.setUrun(seciminID);
    		
    		UpdateItems();
    	});
    }
    public void UpdateItems() {
    	MasaTopLBL.setText(MasaBilgiler.masa.getMasaTutar()+"₺");
    	DisplayVarUrun();
    	DisplaySeciliSpinner();
    }
    public void OdemeAl() {
    	OdemeAlButon.setOnAction(e->{
    		MasaBilgiler.masa.deleteUrunler();
    		UpdateItems();
    	});
    }
    public void DisplayVarUrun() {
    	if(MasaBilgiler.masa.getUrunlerList().isEmpty()==false) {
    	SeciliUrunCombo.getItems().clear();
		Map<String, Integer> adetler = new HashMap<>();
		for (Urun urun : MasaBilgiler.masa.getUrunlerList()) {
			String ad = urun.getUrun_id()+": "+urun.getUrunadi();
			if (!adetler.containsKey(ad)) {
				adetler.put(ad, 1);
			} else {
				int eskiAdet = adetler.get(ad);
				adetler.put(ad, eskiAdet + 1);
			}
			
		}
		for (String ad : adetler.keySet()) {
			SeciliUrunCombo.getItems().add(ad + " x" + adetler.get(ad));
		}
		adetler.clear();}
    	SeciliUrunCombo.setPromptText("Ürün Seçiniz");
    }
    public void DisplaySeciliSpinner() {
    	if(MasaBilgiler.masa.getUrunlerList().isEmpty()==false) {
    	//SeciliUrunCombo.setValue(SeciliUrunCombo.getItems().get(0));
    	SeciliUrunCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
    	    	int i=1;
    	    	if(observable!=null) {
    			String Now=observable.getValue();
    			String NowID=Now.substring(0,Now.indexOf(":"));
    			i=MasaBilgiler.masa.getVarOlanUrunSayi(NowID);
    	    	}
    	    	if(oldValue!=null) {
    	    	String oldValueID=oldValue.substring(0, oldValue.indexOf(":"));
    	    	 i=MasaBilgiler.masa.getVarOlanUrunSayi(oldValueID);
    	    	}
    	    	if(newValue!=null) {
    	    		String newValueID=newValue.substring(0, newValue.indexOf(":"));
        	    	 i=MasaBilgiler.masa.getVarOlanUrunSayi(newValueID);
        	    	
    	    	}
    	    	SeciliUrunAdet.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, i, 1,1));
    	    
    	});
    	}
    }
    public void SeciliUrunOde() {
    	SeciliUrunButton.setOnAction(e->{
    		String hedef=SeciliUrunCombo.getValue();
    		String hedefID=hedef.substring(0,hedef.indexOf(":"));
    		for(int i=1;i<=SeciliUrunAdet.getValue();i++) {
    			MasaBilgiler.masa.deleteUrun(hedefID);
    		}	
    		UpdateItems();
    	
    	});
    }
public void MasaBirlestir() {
	MasaBirlesButon.setOnAction(e->{
		
		Parent root = null;
		try {
			FXMLLoader fxmlmimiz= new FXMLLoader(getClass().getResource("MasaBirlestir.fxml"));
			
			root=fxmlmimiz.load();
			
		} catch (IOException a) {
			a.printStackTrace();
		}
		
		
		Scene sahne=new Scene(root);
		Stage newWindow = new Stage();
		newWindow.setScene(sahne);
		newWindow.setResizable(false);
		newWindow.initModality(Modality.APPLICATION_MODAL);
		newWindow.show();
	});
}
    

}
