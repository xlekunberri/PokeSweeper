package org.pokesweeper.model;

import org.pokesweeper.view.JokoaUI;
import org.pokesweeper.view.LaukiaUI;
import org.pokesweeper.view.TableroaUI;

public class LurLaukia extends BarruLaukia{

	//Atributoak	

	//Eraikitzailea
	public LurLaukia(int pErrenkada, int pZutabea, int pIkonoZenb){
		super(pErrenkada, pZutabea, pIkonoZenb);
	}
	
	//Beste metodoak
	public void ezkerrekoBotoia(){
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		if ((this.egoera == 0 || this.egoera == 2) && !JokoaUI.bukatuta){
			this.egoera = 3;
			laukiHonenUI.setRolloverIcon(null);
			laukiHonenUI.setIcon(Helbideak.lurra[4]);
			laukiHonenUI.repaint();
			Tableroa.getNireTableroa().irabaziDu();
			this.albokoakZabaldu();
		}
	}

	private void albokoakZabaldu() {
		for (int x = this.errenkada - 1; x <= this.errenkada + 1; x++){
			for(int y = this.zutabea - 1; y <= this.zutabea + 1; y++ ){
				if (koordenadaEgokiak(x,y)){
					Tableroa.getNireTableroa().getLaukiBat(x,y).ezkerrekoBotoia();
				}
			}
		}		
	}
	
}
