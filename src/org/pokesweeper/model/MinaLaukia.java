package org.pokesweeper.model;

import org.pokesweeper.view.JokoaUI;
import org.pokesweeper.view.LaukiaUI;
import org.pokesweeper.view.TableroaUI;
import org.pokesweeper.view.PikaUI;

public class MinaLaukia extends BarruLaukia{

	//Eraikitzailea
	public MinaLaukia(int pErrenkada, int pZutabea, int pIkonoZenb){
		this.errenkada = pErrenkada;
		this.zutabea = pZutabea;
		this.egoera = 0;
		this.ikonoZenb = pIkonoZenb;
	}
	
	//Beste metodoak
	public void mouseClicked(){
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		if (this.egoera != 3 && !JokoaUI.galdu){
			this.egoera = 3;
			laukiHonenUI.setRolloverIcon(null);
			laukiHonenUI.setIcon(Helbideak.voltorb);
			laukiHonenUI.repaint();
			PikaUI.getNirePika().setPikaEgoera("galdu");
			JokoaUI.galdu();
		}
	}
	
	
}
