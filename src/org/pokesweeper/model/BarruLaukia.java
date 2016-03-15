package org.pokesweeper.model;

import org.pokesweeper.view.JokoaUI;
import org.pokesweeper.view.LaukiaUI;
import org.pokesweeper.view.PikaUI;
import org.pokesweeper.view.TableroaUI;

public class BarruLaukia{
	
	//Atributoak
	int errenkada;
	int zutabea;
	int egoera;
	int ikonoZenb;
	final Tableroa tableroLogicoa = Tableroa.getNireTableroa();
	
	int getEgoera() {
		return this.egoera;
	}

	
	//Beste metodoak
	public void mouseClicked(boolean pEzkerrekoBotoia) {
		if(pEzkerrekoBotoia){
	    	this.ezkerrekoBotoia();
    	} 
    	else{
    		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
    		if(this.egoera != 3 && !JokoaUI.bukatuta) {
    			if(this.egoera == 0 && JokoaUI.kontadorea.getKont() != 0){
    				this.egoera = 1;
    				laukiHonenUI.setIcon(Helbideak.bandera[this.ikonoZenb]);
    				laukiHonenUI.setRolloverIcon(null);
    				JokoaUI.kontadorea.kontadoreaKendu();
    			}
    			else if(this.egoera == 1){
    				this.egoera = 2;
    				laukiHonenUI.setIcon(new IkonoKonbinaketa(Helbideak.belar_normal[this.ikonoZenb], Helbideak.galdera));
    				laukiHonenUI.setRolloverIcon(null);
    				JokoaUI.kontadorea.kontadoreaGehitu();
    			}
    			else if((this.egoera == 0 && JokoaUI.kontadorea.getKont() == 0)){
    				this.egoera = 2;
    				laukiHonenUI.setIcon(new IkonoKonbinaketa(Helbideak.belar_normal[this.ikonoZenb], Helbideak.galdera));
    				laukiHonenUI.setRolloverIcon(null);
    			} 
    			else{
    				this.egoera = 0;
    				laukiHonenUI.setIcon(Helbideak.belar_normal[this.ikonoZenb]);
    				laukiHonenUI.setRolloverIcon(Helbideak.belar_mugimendu[this.ikonoZenb]);
    			}
    		}
	    }
	}
	
	protected void ezkerrekoBotoia(){
		
	}
	
	public void mouseEntered() {
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
       	if(this.egoera == 0 && !JokoaUI.bukatuta) {
       		laukiHonenUI.setRolloverIcon(Helbideak.belar_mugimendu[this.ikonoZenb]);
       		laukiHonenUI.repaint();
       	}
	}
	
	public void mouseExited() {
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		if(this.egoera == 0 && !JokoaUI.bukatuta) {
			laukiHonenUI.setIcon(Helbideak.belar_normal[this.ikonoZenb]);
    		laukiHonenUI.setRolloverIcon(null);
			laukiHonenUI.repaint();
    	}
	}
	
	public void mousePressed() {
    	if(this.egoera == 0 && !JokoaUI.bukatuta) {
    		PikaUI.getNirePika().setPikaEgoera("klik");
    	}
	}
	
	public void mouseReleased() {
    	if(this.egoera == 0 && !JokoaUI.bukatuta) {
    		PikaUI.getNirePika().setPikaEgoera("normal");
    	}
	}
	
	boolean koordenadaEgokiak(int pErrenkada, int pZutabe){
		return !(pErrenkada< 0 || pErrenkada >= tableroLogicoa.getErrenkadaKop() || pZutabe < 0 || pZutabe >= tableroLogicoa.getZutabeKop());
	}
	
	protected void irabaziDu(){
		Tableroa tableroa = Tableroa.getNireTableroa();
		tableroa.laukiFalta--;
		if(tableroa.laukiFalta == tableroa.getMinaKop()){
			JokoaUI.irabazi();
		}
	}
	
	public void minakBistaratu(){
		
	}
	
}
