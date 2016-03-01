package org.pokesweeper.model;

public class Tableroa {
	
	//Atributoak
	private static Tableroa nireTableroa;
	public BarruLaukia laukia[][];
	private int errenkada;
	private int zutabe;
	private int minaKop;
	
	//Eraikitzailea
	private Tableroa(){
		
	}
	
	public static Tableroa getNireTableroa(){
		if (nireTableroa == null){
			nireTableroa = new Tableroa();
		}
		return nireTableroa;
	}
	
	//Beste Metodoak	
	public void setTamaina(int pErrenkada, int pZutabe, int pMinaKop) {
		this.errenkada = pErrenkada;
		this.zutabe = pZutabe;
		this.minaKop = pMinaKop;
	}
	
	public void tableroaEraiki(){
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
	/*				DAFUQ IS THAT? ENEKO PLS

	private boolean posizioEgokia(int pErre, int pZut) {
		if(pErre < 0 || pErre >= this.errenkada || pZut < 0 || pZut >= this.zutabe)
			return false;
		else
			return true;
	}
	
	private int zenbakiaKalkulatu(int pErren, int pZut) {
		int zenbakia = 0;
		
		if(posizioEgokia(pErren-1, pZut-1)) {
			if(this.laukia[pErren-1][pZut-1].isMina()){
				zenbakia++;
			}
		}
		if(posizioEgokia(pErren, pZut-1)) {
			if(this.laukia[pErren][pZut-1].isMina()){
				zenbakia++;
			}
		}
		if(posizioEgokia(pErren+1, pZut-1)) {
			if(this.laukia[pErren+1][pZut-1].isMina()){
				zenbakia++;
			}
		}
		if(posizioEgokia(pErren-1, pZut)) {
			if(this.laukia[pErren-1][pZut].isMina()){
				zenbakia++;
			}
		}
		if(posizioEgokia(pErren+1, pZut)) {
			if(this.laukia[pErren+1][pZut].isMina()){
				zenbakia++;
			}
		}
		if(posizioEgokia(pErren-1, pZut+1)) {
			if(this.laukia[pErren-1][pZut+1].isMina()){
				zenbakia++;
			}
		}
		if(posizioEgokia(pErren, pZut+1)) {
			if(this.laukia[pErren][pZut+1].isMina()){
				zenbakia++;
			}
		}
		if(posizioEgokia(pErren+1, pZut+1)) {
			if(this.laukia[pErren+1][pZut+1].isMina()){
				zenbakia++;
			}
		}
		
		return zenbakia;
	}
	
	private boolean aztertutaDago(int pErren, int pZut) {
		return this.laukia[pErren][pZut].isAztertuta();
	}
	*/	
}
