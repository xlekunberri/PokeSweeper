package org.pokesweeper.model;

import org.pokesweeper.view.IkonoKonbinaketa;
import org.pokesweeper.view.JokoaUI;
import org.pokesweeper.view.LaukiaUI;
import org.pokesweeper.view.TableroaUI;

public class ZenbLaukia extends BarruLaukia{
	
	//Atributoak
	private final int ingurukoMinaKop;
	
	//Eraikitzailea
	public ZenbLaukia(int pErrenkada, int pZutabea, int pIkonoZenb, int pIngurukoMinaKop){
		this.errenkada = pErrenkada;
		this.zutabea = pZutabea;
		this.egoera = 0;
		this.ikonoZenb = pIkonoZenb;
		this.ingurukoMinaKop = pIngurukoMinaKop;
	}
	
	//Beste metodoak
	public void mouseClicked(){
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		if (this.egoera != 3 && !JokoaUI.galdu){
			this.egoera = 3;
			laukiHonenUI.setRolloverIcon(null);
			laukiHonenUI.setIcon(new IkonoKonbinaketa(Helbideak.lurra[4],Helbideak.zenbaki[this.ingurukoMinaKop-1]));
			laukiHonenUI.repaint();
			//TODO: RECALCULAR LAS BELARRAK!
		}
	}
	
	public void minakBistaratu(){
		this.egoera = 4;
		for (int x = this.errenkada - 1; x <= this.errenkada + 1; x++){
			for(int y = this.zutabea - 1; y <= this.zutabea + 1; y++ ){
				if (koordenadaEgokiak(x,y) && tableroLogicoa.laukia[x][y].egoera != 4){
					tableroLogicoa.laukia[x][y].minakBistaratu();
				}
			}
		}		
	}	

}
