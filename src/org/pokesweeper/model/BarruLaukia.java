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
	
	public int getEgoera() {
		return this.egoera;
	}

	
	//Beste metodoak
	public void mouseClicked() {}
	
	public void mouseEntered() {
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
       	if(this.egoera != 3 && !JokoaUI.bukatuta) {
        	laukiHonenUI.setRolloverIcon(Helbideak.belar_mugimendu[4]);
       		laukiHonenUI.repaint();
       	}
	}
	
	public void mouseExited() {
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		if(this.egoera != 3 && !JokoaUI.bukatuta) {
			laukiHonenUI.setIcon(Helbideak.belar_normal[this.ikonoZenb]);
    		laukiHonenUI.setRolloverIcon(null);
			laukiHonenUI.repaint();
    	}
	}
	
	public void mousePressed() {
    	if(this.egoera != 3 && !JokoaUI.bukatuta) {
    		PikaUI.getNirePika().setPikaEgoera("klik");
    	}
	}
	
	public void mouseReleased() {
    	if(this.egoera != 3 && !JokoaUI.bukatuta) {
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
