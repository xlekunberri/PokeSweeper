package org.pokesweeper.model;

import org.pokesweeper.view.JokoaUI;
import org.pokesweeper.view.LaukiaUI;
import org.pokesweeper.view.TableroaUI;

public class MinaLaukia extends BarruLaukia{

	//Eraikitzailea
	public MinaLaukia(int pErrenkada, int pZutabea, int pIkonoZenb){
		this.errenkada = pErrenkada;
		this.zutabea = pZutabea;
		this.egoera = 0;
		this.ikonoZenb = pIkonoZenb;
	}
	
	//Beste metodoak
	public void ezkerrekoBotoia(){
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		if ((this.egoera == 0 || this.egoera == 2) && !JokoaUI.bukatuta){
			this.egoera = 3;
			laukiHonenUI.setRolloverIcon(null);
			laukiHonenUI.setIcon(Helbideak.voltorb);
			laukiHonenUI.repaint();
			this.minakBistaratu();
			JokoaUI.galdu();
		}
	}

	public void minakBistaratu(){
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		this.egoera = 4;
		for (int x = this.errenkada - 1; x <= this.errenkada + 1; x++){
			for(int y = this.zutabea - 1; y <= this.zutabea + 1; y++ ){
				if (koordenadaEgokiak(x,y) && tableroLogicoa.laukia[x][y].egoera != 4){
					tableroLogicoa.laukia[x][y].minakBistaratu();
				}
			}
		}
		laukiHonenUI.setRolloverIcon(null);
		laukiHonenUI.setIcon(Helbideak.voltorb);
		laukiHonenUI.repaint();
	}
	
}
