package org.pokesweeper.model;

import org.pokesweeper.view.JokoaUI;
import org.pokesweeper.view.LaukiaUI;
import org.pokesweeper.view.PikaUI;
import org.pokesweeper.view.TableroaUI;

public class BarruLaukia extends Laukia{
	
	//Atributoak
	protected int errenkada;
	protected int zutabea;
	protected int egoera;
	protected int ikonoZenb;
	private LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
	
	//Beste metodoak
	public void mouseClicked() {

	}
	
	public void mouseEntered() {
        	if(this.egoera != 3 && !JokoaUI.galdu) {
        		laukiHonenUI.setRolloverIcon(Helbideak.belar_mugimendu[this.ikonoZenb]);
        		laukiHonenUI.repaint();
        	}
	}
	
	public void mouseExited() {
		if(this.egoera != 3 && !JokoaUI.galdu) {
			laukiHonenUI.setIcon(Helbideak.belar_normal[this.ikonoZenb]);
			laukiHonenUI.repaint();
    	}
	}
	
	public void mousePressed() {
    	if(this.egoera != 3 && !JokoaUI.galdu) {
    		PikaUI.getNirePika().setPikaEgoera("click");
    	}
	}
	
	public void mouseReleased() {
    	PikaUI.getNirePika().setPikaEgoera("normal");
	}

}
