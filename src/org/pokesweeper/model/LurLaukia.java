package org.pokesweeper.model;

import org.pokesweeper.view.JokoaUI;
import org.pokesweeper.view.LaukiaUI;
import org.pokesweeper.view.TableroaUI;

public class LurLaukia extends BarruLaukia{

	//Eraikitzailea
	public LurLaukia(int pErrenkada, int pZutabea, int pIkonoZenb){
		this.errenkada = pErrenkada;
		this.zutabea = pZutabea;
		this.egoera = 0; // 0 = Zabaldu gabe; 1 = Bandera; 2 = Galdera ikurra; 3 = Zabalik; 4 = MinaBistaratu pasatuta
		this.ikonoZenb = pIkonoZenb;
	}
	
	//Beste metodoak
	public void mouseClicked(){
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		if (this.egoera != 3 && !JokoaUI.bukatuta){
			this.egoera = 3;
			laukiHonenUI.setRolloverIcon(null);
			laukiHonenUI.setIcon(Helbideak.lurra[4]);
			laukiHonenUI.repaint();
			this.irabaziDu();
			this.albokoakZabaldu();
		}
	}

	private void albokoakZabaldu() {
		for (int x = this.errenkada - 1; x <= this.errenkada + 1; x++){
			for(int y = this.zutabea - 1; y <= this.zutabea + 1; y++ ){
				if (koordenadaEgokiak(x,y)){
					tableroLogicoa.laukia[x][y].mouseClicked();
				}
			}
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
