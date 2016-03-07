package org.pokesweeper.model;

import org.pokesweeper.view.TableroaUI;

public class Tableroa {
	
	//Atributoak
	private static int tableroZenb = 0;
	private static Tableroa nireTableroa;
	public BarruLaukia laukia[][];
	private int errenkadaKop;
	private int zutabeKop;
	private int minaKop;
	
	//Eraikitzailea
	private Tableroa(){}
	
	public static Tableroa getNireTableroa(){
		if (nireTableroa == null){
			nireTableroa = new Tableroa();
		}
		return nireTableroa;
	}
	
	//Beste Metodoak	
	public void tableroaEraiki(int pErrenkada, int pZutabe, int pMinaKop){
		this.errenkadaKop = pErrenkada;
		this.zutabeKop = pZutabe;
		this.minaKop = pMinaKop;
		this.laukia = new BarruLaukia[this.errenkadaKop][this.zutabeKop];
		LaukiFactory factory = LaukiFactory.getNireFactory();
		factory.setTamaina(this.errenkadaKop, this.zutabeKop, this.minaKop);
		for(int erren = 0; erren < this.errenkadaKop; erren++) {
			for(int zut = 0; zut < this.zutabeKop; zut++) {
				this.laukia[erren][zut] = factory.createLaukiLogikoa(erren, zut);
			}
		}
		if (tableroZenb == 0){
			tableroZenb = 1;
		}
	}
	
	public int getErrenkadaKop(){
		return this.errenkadaKop;
	}
	
	public int getZutabeKop(){
		return this.zutabeKop;
	}
	
	public int getMinaKop(){
		return this.minaKop;
	}

	public boolean lehenengoTxanda() {
		if (tableroZenb == 0){
			return true;
		}
		else{return false;}
	}
	
	private boolean koordenadaEgokiak(int pErrenkada, int pZutabe){
		return !(pErrenkada < 0 || pErrenkada >= this.errenkadaKop || pZutabe < 0 || pZutabe >= this.zutabeKop);
	}
	
	public void laukiakBerrekalkulatu(int pErren, int pZut) {
		System.out.println(pErren + " " + pZut);
		goikoaBerrekalkulatu(pErren-1, pZut);
		behekoaErrekalkulatu(pErren+1, pZut);
		ezkerrekoaBerrekalkulatu(pErren, pZut-1);
		eskuinekoaBerrekalkulatu(pErren, pZut+1);
	}
	
	private void goikoaBerrekalkulatu(int pErren, int pZut) {
		System.out.println("lol");
		TableroaUI tableroaUI = TableroaUI.getNireTableroaUI();
		if(koordenadaEgokiak(pErren-1, pZut) && this.laukia[pErren-1][pZut].getEgoera() == 3) { //GOIAN
			if(koordenadaEgokiak(pErren, pZut+1) && this.laukia[pErren][pZut+1].getEgoera() == 3) { // ESKUINA
				if(koordenadaEgokiak(pErren, pZut-1) && this.laukia[pErren][pZut-1].getEgoera() == 3) { // EZKERRA
					tableroaUI.belarraAldatu(pErren, pZut, 9);
				}
				else {
					tableroaUI.belarraAldatu(pErren, pZut, 2);
				}
			}
			else {
				if(koordenadaEgokiak(pErren, pZut-1) && this.laukia[pErren][pZut-1].getEgoera() == 3) {
					tableroaUI.belarraAldatu(pErren, pZut, 13);
				}
				else {
					tableroaUI.belarraAldatu(pErren, pZut, 10);
				}
			}
		}
		else {
			if(koordenadaEgokiak(pErren, pZut+1) && this.laukia[pErren][pZut+1].getEgoera() == 3) {
				if(koordenadaEgokiak(pErren, pZut-1) && this.laukia[pErren][pZut-1].getEgoera() == 3) {
					tableroaUI.belarraAldatu(pErren, pZut, 1);
				}
				else {
					tableroaUI.belarraAldatu(pErren, pZut, 8);
				}
			}
			else {
				if(koordenadaEgokiak(pErren, pZut-1) && this.laukia[pErren][pZut-1].getEgoera() == 3) {
					tableroaUI.belarraAldatu(pErren, pZut, 6);
				}
				else {
					if(koordenadaEgokiak(pErren, pZut))
						tableroaUI.belarraAldatu(pErren, pZut, 7);
				}
			}
		}
	}
	
	private void behekoaErrekalkulatu(int pErren, int pZut) {
			
		}
	
	private void ezkerrekoaBerrekalkulatu(int pErren, int pZut) {
		
	}
	
	private void eskuinekoaBerrekalkulatu(int pErren, int pZut) {
		
}
}
