package org.pokesweeper.model;

import org.pokesweeper.view.LaukiaUI;
import org.pokesweeper.view.TableroaUI;
import org.pokesweeper.view.PikaUI;

public class MinaLaukia extends BarruLaukia{
	
	//Atributoak
	private int errenkada;
	private int zutabea;
	private int egoera;
	private int ikonoZenb;
	private LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
	
	//Eraikitzailea
	public MinaLaukia(int pErrenkada, int pZutabea, int pIkonoZenb){
		this.errenkada = pErrenkada;
		this.zutabea = pZutabea;
		this.egoera = 0;
		this.ikonoZenb = pIkonoZenb;
	}
	
	//Beste metodoak
	public void mouseClicked(){
		if (this.egoera != 3){
			this.egoera = 3;
			laukiHonenUI.setRolloverIcon(null);
			laukiHonenUI.setIcon(Helbideak.voltorb);
			PikaUI.getNirePika().setPikaEgoera("galdu");
			laukiHonenUI.repaint();
			//TODO: HACER LO QUE HAGA FALTA PARA PERDER!
		}
	}
	
	
}
