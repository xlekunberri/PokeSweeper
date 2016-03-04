package org.pokesweeper.model;

import org.pokesweeper.view.JokoaUI;
import org.pokesweeper.view.LaukiaUI;
import org.pokesweeper.view.TableroaUI;

public class LurLaukia extends BarruLaukia{
	
	private final Tableroa tableroLogicoa = Tableroa.getNireTableroa();

	//Eraikitzailea
	public LurLaukia(int pErrenkada, int pZutabea, int pIkonoZenb){
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
			laukiHonenUI.setIcon(Helbideak.lurra[4]);
			laukiHonenUI.repaint();
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
	
	private boolean koordenadaEgokiak(int pErrenkada, int pZutabe){
		return !(pErrenkada< 0 || pErrenkada >= tableroLogicoa.getErrenkadaKop() || pZutabe < 0 || pZutabe >= tableroLogicoa.getZutabeKop());
	}
	
}
