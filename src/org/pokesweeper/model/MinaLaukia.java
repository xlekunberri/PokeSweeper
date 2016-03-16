package org.pokesweeper.model;

import org.pokesweeper.view.JokoaUI;
import org.pokesweeper.view.LaukiaUI;
import org.pokesweeper.view.TableroaUI;

public class MinaLaukia extends BarruLaukia{

	//Eraikitzailea
	public MinaLaukia(int pErrenkada, int pZutabea, int pIkonoZenb){
		super(pErrenkada, pZutabea, pIkonoZenb);
	}
	
	//Beste metodoak
	public void ezkerrekoBotoia(){
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		if ((this.egoera == 0 || this.egoera == 2) && !JokoaUI.bukatuta){
			this.egoera = 3;
			laukiHonenUI.setRolloverIcon(null);
			laukiHonenUI.setIcon(Helbideak.voltorb);
			laukiHonenUI.repaint();
			Tableroa.getNireTableroa().minakBistaratu();
		}
	}

	public void bistaratu(){
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		laukiHonenUI.setRolloverIcon(null);
		if(this.egoera == 1){
			laukiHonenUI.setIcon(Helbideak.voltorb_s);
		}
		else {
			laukiHonenUI.setIcon(Helbideak.voltorb);
		}
		laukiHonenUI.repaint();
	}
	
}
