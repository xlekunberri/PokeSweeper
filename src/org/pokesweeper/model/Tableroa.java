package org.pokesweeper.model;

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
}
