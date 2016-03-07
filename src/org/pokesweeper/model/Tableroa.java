package org.pokesweeper.model;

public class Tableroa {
	
	//Atributoak
	private static Tableroa nireTableroa;
	public BarruLaukia laukia[][];
	private int errenkadaKop;
	private int zutabeKop;
	private int minaKop;
	public int laukiFalta;
	
	//Eraikitzailea
	private Tableroa(){}
	
	public static Tableroa getNireTableroa(){
		if (nireTableroa == null){
			nireTableroa = new Tableroa();
		}
		return nireTableroa;
	}
	
	//Beste Metodoak	
	public void tableroaEraiki(int pErrenkada, int pZutabe, int pMinaKop, boolean pBichilloak){
		this.errenkadaKop = pErrenkada;
		this.zutabeKop = pZutabe;
		this.minaKop = pMinaKop;
		this.laukiFalta = this.errenkadaKop * this.zutabeKop;
		this.laukia = new BarruLaukia[this.errenkadaKop][this.zutabeKop];
		LaukiFactory factory = LaukiFactory.getNireFactory();
		factory.setTamaina(this.errenkadaKop, this.zutabeKop, this.minaKop);
		for(int erren = 0; erren < this.errenkadaKop; erren++) {
			for(int zut = 0; zut < this.zutabeKop; zut++) {
				this.laukia[erren][zut] = factory.createLaukiLogikoa(erren, zut, pBichilloak);
			}
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
	
}
