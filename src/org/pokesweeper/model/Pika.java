package org.pokesweeper.model;

import javax.swing.Icon;

import org.pokesweeper.view.JokoaUI;
import org.pokesweeper.view.PikaUI;

public class Pika {
	
	//Atributoak
	private static Pika nirePika;
	
	//Eraikitzailea
	public static Pika getNirePika() {
		if (nirePika == null) {
			nirePika = new Pika();
		}
		return nirePika;
	}
	
	private Pika(){
		
	}
	
	//Beste metodoak
	public void ezkerrekoKlik(){
		Tableroa tableroa = Tableroa.getNireTableroa();
		if (tableroa.getMinaKop()!=0){
			JokoaUI.getNireJokoa().erreseteatu(tableroa.getErrenkadaKop(), tableroa.getZutabeKop(), tableroa.getMinaKop(), false);
	    	Tableroa.getNireTableroa().denboraKontadorea.denboraErreseteatu();
	    	this.setPikaEgoera("normal");
		}
	}
	
	public void eskumakoKlik(){
    	Tableroa tableroa = Tableroa.getNireTableroa();
		JokoaUI.getNireJokoa().erreseteatu(tableroa.getErrenkadaKop(), tableroa.getZutabeKop(), tableroa.getMinaKop(), true);
    	Tableroa.getNireTableroa().denboraKontadorea.denboraErreseteatu();
    	this.setPikaEgoera("normal");
	}
	
	public void setPikaEgoera(String pEgoera){
		Icon ikonoa = null;
		switch (pEgoera) {
		case "normal":
			ikonoa = Helbideak.pikaNormal;
			break;
		case "irabazi":
			ikonoa = Helbideak.pikaIrabazi;
			break;
		case "galdu":
			ikonoa = Helbideak.pikaGaldu;
			break;
		case "klik":
			ikonoa = Helbideak.pikaKlik;
			break;
		}
		PikaUI.getNirePika().setPikaEgoera(ikonoa);
	}

}
