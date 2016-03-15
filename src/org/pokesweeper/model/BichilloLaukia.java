package org.pokesweeper.model;
import org.pokesweeper.view.LaukiaUI;
import org.pokesweeper.view.TableroaUI;

public class BichilloLaukia extends BarruLaukia {
	
	
	public BichilloLaukia(int pErrenkada, int pZutabea, int pIkonoZenb){
		this.errenkada = pErrenkada;
		this.zutabea = pZutabea;
		this.egoera = 0;
		this.ikonoZenb = pIkonoZenb;
	}
	
	//Beste metodoak
	@Override
	public void mouseClicked(boolean pEzkerrekoBotoia) {
		if(this.egoera != 3 && pEzkerrekoBotoia){
			this.egoera = 3;
			LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
			laukiHonenUI.setRolloverIcon(null);
			int p = (int)(Math.random() * Helbideak.bichilloak.length);
			laukiHonenUI.setIcon(Helbideak.bichilloak[p]);
			laukiHonenUI.repaint();
		}
	}
	
	@Override
	public void mousePressed(){
		
	}
	
	@Override
	public void mouseReleased(){
		
	}

}
