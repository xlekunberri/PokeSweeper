package org.pokesweeper.model;

import java.awt.event.MouseEvent;

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
	
	public int getEgoera() {
		return this.egoera;
	}

	
	//Beste metodoak
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
	    	this.ezkerrekoBotoia();
    	} 
    	else if(e.getButton() == MouseEvent.BUTTON3){
    		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
    		if(this.egoera != 3 && !JokoaUI.bukatuta) {
    			if(this.egoera == 0 && JokoaUI.kontadorea.getKont() != 0){
    				this.egoera = 1;
    				laukiHonenUI.setIcon(new IkonoKonbinaketa(Helbideak.belar_normal[this.ikonoZenb], Helbideak.bandera));
    				laukiHonenUI.setRolloverIcon(null);
    				JokoaUI.kontadorea.kontadoreaKendu();
    			}
    			else if(this.egoera == 1){
    				this.egoera = 2;
    				laukiHonenUI.setIcon(new IkonoKonbinaketa(Helbideak.belar_normal[this.ikonoZenb], Helbideak.galdera));
    				laukiHonenUI.setRolloverIcon(null);
    				JokoaUI.kontadorea.kontadoreaGehitu();
    			}
    			else{
    				this.egoera = 0;
    				laukiHonenUI.setIcon(Helbideak.belar_normal[this.ikonoZenb]);
    				laukiHonenUI.setRolloverIcon(null);
    			}
    		}
	    }
	}
	
	protected void ezkerrekoBotoia(){
		
	}
	
	public void mouseEntered(MouseEvent e) {
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
       	if(this.egoera == 0 && !JokoaUI.bukatuta) {
       		laukiHonenUI.setRolloverIcon(Helbideak.belar_mugimendu[this.ikonoZenb]);
       		laukiHonenUI.repaint();
       	}
	}
	
	public void mouseExited(MouseEvent e) {
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		if(this.egoera == 0 && !JokoaUI.bukatuta) {
			laukiHonenUI.setIcon(Helbideak.belar_normal[this.ikonoZenb]);
    		laukiHonenUI.setRolloverIcon(null);
			laukiHonenUI.repaint();
    	}
	}
	
	public void mousePressed(MouseEvent e) {
    	if(this.egoera == 0 && !JokoaUI.bukatuta && e.getButton() == MouseEvent.BUTTON1) {
    		PikaUI.getNirePika().setPikaEgoera("klik");
    	}
	}
	
	public void mouseReleased(MouseEvent e) {
    	if(this.egoera == 0 && !JokoaUI.bukatuta) {
    		PikaUI.getNirePika().setPikaEgoera("normal");
    	}
	}
	
	protected boolean koordenadaEgokiak(int pErrenkada, int pZutabe){
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
