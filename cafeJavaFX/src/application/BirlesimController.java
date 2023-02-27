package application;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class BirlesimController {

    @FXML
    private Button MasaBirlestirmeButton;

    @FXML
    private ComboBox<String> MasaBirlestirmeCombo;
public void initialize() {
	DisplayMasalar();
	Birlestirme();
}

public void DisplayMasalar() {
	List<kat> Katlar= new ArrayList<kat>();
	Katlar.add(KatController.kat_1);
	Katlar.add(KatController.kat_2);
	Katlar.add(KatController.kat_3);
	for(kat _kat:Katlar) {
		for(Masa masa:_kat.getMasa()) {
				if(MasaBilgiler.masa.getID().equals(masa.getID()))
					continue;
				else
					MasaBirlestirmeCombo.getItems().add("Masa "+masa.getID()+": "+"Kat "+_kat.getKatID());
		}
	}

}
public void Birlestirme() {
	MasaBirlestirmeButton.setOnAction(e->{
		
		String secim=MasaBirlestirmeCombo.getValue();
		String secimID=secim.substring(5,secim.indexOf(":"));
		//System.out.println(secimID);
		Masa masa=null;
		if(KatController.kat_1.find_masa(secimID)!=null)
			masa=KatController.kat_1.find_masa(secimID);
		else if(KatController.kat_2.find_masa(secimID)!=null)
			masa=KatController.kat_2.find_masa(secimID);
		else if(KatController.kat_3.find_masa(secimID)!=null)
			masa=KatController.kat_3.find_masa(secimID);
		
		if(masa!=null)
			MasaBilgiler.masa.BirlestirMasa(masa);
		
	});
}
}

