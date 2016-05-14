package org.pokesweeper.model;

import org.pokesweeper.view.JokoaUI;
import org.pokesweeper.view.LaukiaUI;
import org.pokesweeper.view.TableroaUI;

public class ZenbLaukia extends BarruLaukia{
	
	//Atributoak
	private final int ingurukoMinaKop;
	
	//Eraikitzailea
	public ZenbLaukia(int pErrenkada, int pZutabea, int pIkonoZenb, int pIngurukoMinaKop){
		super(pErrenkada, pZutabea, pIkonoZenb);
		this.ingurukoMinaKop = pIngurukoMinaKop;
	}
	
	//Beste metodoak
	public void ezkerrekoBotoia(){
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		if ((this.egoera == 0 || this.egoera == 2) && !JokoaUI.bukatuta){
			this.egoera = 3;
			laukiHonenUI.setRolloverIcon(null);
			laukiHonenUI.setIcon(new IkonoKonbinaketa(Helbideak.lurra[4],Helbideak.zenbaki[this.ingurukoMinaKop-1]));
			laukiHonenUI.repaint();
			Tableroa.getNireTableroa().irabaziDu();
		}
	}

}
