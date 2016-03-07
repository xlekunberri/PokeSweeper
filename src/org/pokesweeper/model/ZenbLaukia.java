package org.pokesweeper.model;

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
	public void ezkerrekoBotoia(){
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		if (this.egoera == 0 && !JokoaUI.bukatuta){
			this.egoera = 3;
			laukiHonenUI.setRolloverIcon(null);
			laukiHonenUI.setIcon(new IkonoKonbinaketa(Helbideak.lurra[4],Helbideak.zenbaki[this.ingurukoMinaKop-1]));
			laukiHonenUI.repaint();
			this.irabaziDu();
		//	this.belarrakBerrekalkulatu();
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
	
	public void belarrakBerrekalkulatu() {
		if(koordenadaEgokiak(this.errenkada-1, this.zutabea)){
			goikoaBerrekalkulatu();
		}
		if(koordenadaEgokiak(this.errenkada+1, this.zutabea)){
			behekoaErrekalkulatu();
		}
		if(koordenadaEgokiak(this.errenkada, this.zutabea-1)){
			ezkerrekoaBerrekalkulatu();
		}
		if(koordenadaEgokiak(this.errenkada, this.zutabea+1)){
			eskuinekoaBerrekalkulatu();
		}
	}
	
	private void goikoaBerrekalkulatu() {
		Tableroa tableroa = Tableroa.getNireTableroa();
		LaukiaUI goikoLaukiaUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada-1][this.zutabea];
		if(koordenadaEgokiak(this.errenkada-1, this.zutabea) && tableroa.laukia[this.errenkada-1][this.zutabea].getEgoera() == 3) { //GOIAN
			if(koordenadaEgokiak(this.errenkada, this.zutabea+1) && tableroa.laukia[this.errenkada][this.zutabea+1].getEgoera() == 3) { // ESKUINA
				if(koordenadaEgokiak(this.errenkada, this.zutabea-1) && tableroa.laukia[this.errenkada][this.zutabea-1].getEgoera() == 3) { // EZKERRA
					goikoLaukiaUI.setIcon(Helbideak.belar_normal[9]); //HIERBA CERRADA POR TODOS LOS LADOS
				}
				else {
					goikoLaukiaUI.setIcon(Helbideak.belar_normal[2]); //HIERBA ABIERTA POR LA IZQUIERDA
				}
			}
			else {
				if(koordenadaEgokiak(this.errenkada, this.zutabea-1) && tableroa.laukia[this.errenkada][this.zutabea-1].getEgoera() == 3) {
					goikoLaukiaUI.setIcon(Helbideak.belar_normal[13]);
				}
				else {
					goikoLaukiaUI.setIcon(Helbideak.belar_normal[10]);
				}
			}
		}
		else {
			if(koordenadaEgokiak(this.errenkada, this.zutabea+1) && tableroa.laukia[this.errenkada][this.zutabea+1].getEgoera() == 3) {
				if(koordenadaEgokiak(this.errenkada, this.zutabea-1) && tableroa.laukia[this.errenkada][this.zutabea-1].getEgoera() == 3) {
					goikoLaukiaUI.setIcon(Helbideak.belar_normal[1]);
				}
				else {
					goikoLaukiaUI.setIcon(Helbideak.belar_normal[8]);
				}
			}
			else {
				if(koordenadaEgokiak(this.errenkada, this.zutabea-1) && tableroa.laukia[this.errenkada][this.zutabea-1].getEgoera() == 3) {
					goikoLaukiaUI.setIcon(Helbideak.belar_normal[6]);
				}
				else 
					if(koordenadaEgokiak(this.errenkada, this.zutabea)){
						goikoLaukiaUI.setIcon(Helbideak.belar_normal[7]);
				}
			}
		}
	}
	
	private void behekoaErrekalkulatu() {
			
	}
	
	private void ezkerrekoaBerrekalkulatu() {
		
	}
	
	private void eskuinekoaBerrekalkulatu() {
		
	}

}
