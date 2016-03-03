package org.pokesweeper.model;

public class Tableroa {
	
	//Atributoak
	private static Tableroa nireTableroa;
	public BarruLaukia laukia[][];
	private int errenkada;
	private int zutabe;
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
	/*public void setTamaina(int pErrenkada, int pZutabe, int pMinaKop) {
		this.errenkada = pErrenkada;
		this.zutabe = pZutabe;
		this.minaKop = pMinaKop;
		this.laukia = new BarruLaukia[this.errenkada][this.zutabe];
	}*/
	
	public void tableroaEraiki(int pErrenkada, int pZutabe, int pMinaKop){
		this.errenkada = pErrenkada;
		this.zutabe = pZutabe;
		this.minaKop = pMinaKop;
		this.laukia = new BarruLaukia[this.errenkada][this.zutabe];
		LaukiFactory factory = LaukiFactory.getNireFactory();
		factory.setTamaina(this.errenkada, this.zutabe, this.minaKop);
		for(int erren = 0; erren < this.errenkada; erren++) {
			for(int zut = 0; zut < this.zutabe; zut++) {
				this.laukia[erren][zut] = factory.createLaukiLogikoa(erren, zut);
			}
		}
	}
	
	public int getErrenkadaKop(){
		return this.errenkada;
	}
	
	public int getZutabeKop(){
		return this.zutabe;
	}
}
