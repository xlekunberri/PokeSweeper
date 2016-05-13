package org.pokesweeper.model;

import org.pokesweeper.view.JokoaUI;
import org.pokesweeper.view.LaukiaUI;
import org.pokesweeper.view.TableroaUI;

public class BarruLaukia{
	
	//Atributoak
	protected int errenkada;
	protected int zutabea;
	protected int egoera;
	private int ikonoZenb;
	
	//Eraikitzailea
	protected BarruLaukia(int pErrenkada, int pZutabea, int pIkonoZenb) {
		this.errenkada = pErrenkada;
		this.zutabea = pZutabea;
		this.ikonoZenb = pIkonoZenb;
		this.egoera = 0; // 0 = Zabaldu gabe; 1 = Bandera; 2 = Galdera ikurra; 3 = Zabalik;
	}
	public BarruLaukia(int pErrenkada, int pZutabea) {//JUNIT-entzako
		this.errenkada = pErrenkada;
		this.zutabea = pZutabea;
		this.egoera = 0; // 0 = Zabaldu gabe; 1 = Bandera; 2 = Galdera ikurra; 3 = Zabalik;
	}
	
	//Beste metodoak
	public void eskumakoBotoia() {
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		if(this.egoera != 3 && !JokoaUI.bukatuta) {
			
			if(this.egoera == 0 && Tableroa.minaKontadorea.getKont() != 0){
				this.egoera = 1;
				laukiHonenUI.setIcon(Helbideak.bandera[this.ikonoZenb]);
				laukiHonenUI.setRolloverIcon(Helbideak.bandera[this.ikonoZenb]);
				Tableroa.minaKontadorea.minaKendu();
			}
			else if(this.egoera == 1){
				this.egoera = 2;
				laukiHonenUI.setIcon(new IkonoKonbinaketa(Helbideak.belar_normal[this.ikonoZenb], Helbideak.galdera));
				laukiHonenUI.setRolloverIcon(null);
				Tableroa.minaKontadorea.minaGehitu();
			}
			else if((this.egoera == 0 && Tableroa.minaKontadorea.getKont() == 0)){
				this.egoera = 2;
				laukiHonenUI.setIcon(new IkonoKonbinaketa(Helbideak.belar_normal[this.ikonoZenb], Helbideak.galdera));
				laukiHonenUI.setRolloverIcon(null);
			} 
			else{
				this.egoera = 0;
				laukiHonenUI.setIcon(Helbideak.belar_normal[this.ikonoZenb]);
				laukiHonenUI.setRolloverIcon(Helbideak.belar_mugimendu[this.ikonoZenb]);
			}
		}
	}
	
	public void ezkerrekoBotoia(){
		
	}
	
	public void mouseEntered() {
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
       	if(this.egoera == 0 && !JokoaUI.bukatuta) {
       		laukiHonenUI.setRolloverIcon(Helbideak.belar_mugimendu[this.ikonoZenb]);
       		laukiHonenUI.repaint();
       	}
	}
	
	public void mouseExited() {
		LaukiaUI laukiHonenUI = TableroaUI.getNireTableroaUI().laukia[this.errenkada][this.zutabea];
		if(this.egoera == 0 && !JokoaUI.bukatuta) {
			laukiHonenUI.setIcon(Helbideak.belar_normal[this.ikonoZenb]);
    		laukiHonenUI.setRolloverIcon(null);
			laukiHonenUI.repaint();
    	}
	}
	
	public void mousePressed() {
    	if(this.egoera == 0 && !JokoaUI.bukatuta) {
    		Pika.getNirePika().setPikaEgoera("klik");
    	}
	}
	
	public void mouseReleased() {
    	if(this.egoera == 0 && !JokoaUI.bukatuta) {
    		Pika.getNirePika().setPikaEgoera("normal");
    	}
	}
	
	protected boolean koordenadaEgokiak(int pErrenkada, int pZutabe){
		return !(pErrenkada< 0 || pErrenkada >= Tableroa.getNireTableroa().getErrenkadaKop() || pZutabe < 0 || pZutabe >= Tableroa.getNireTableroa().getZutabeKop());
	}
	
	public boolean jKoordenadaEgokiak(int pErrenkada, int pZutabe){//JUNIT-entzako
		return !(pErrenkada< 0 || pErrenkada >= Tableroa.getNireTableroa().getErrenkadaKop() || pZutabe < 0 || pZutabe >= Tableroa.getNireTableroa().getZutabeKop());
	}
	
	public boolean jIrabaziDu(){//JUNIT-entzako
		Tableroa tableroa = Tableroa.getNireTableroa();
		tableroa.laukiFalta--;
		if(tableroa.laukiFalta == tableroa.getMinaKop()){
			JokoaUI.irabazi();
			return true;
		}
		return false;
	}
	
	
	public int getEgoera() {
		return this.egoera;
	}
	
	public int getIkonoZenb(){
		return this.ikonoZenb;
	}
	
}
