package org.pokesweeper.model;

import org.pokesweeper.view.LaukiaUI;
import org.pokesweeper.view.TableroaUI;

public class ZenbLaukia extends BarruLaukia{
	
	//Atributoak
	private int errenkada;
	private int zutabea;
	private int egoera;
	private int ikonoZenb;
	private int ingurukoMinaKop;
	private LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
	
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
		if (this.egoera != 3){
			this.egoera = 3;
			laukiHonenUI.setRolloverIcon(null);
			laukiHonenUI.setIcon(Helbideak.zenbaki[this.ingurukoMinaKop]);
			laukiHonenUI.repaint();
			//TODO: RECALCULAR LAS BELARRAK!
		}
	}
}
