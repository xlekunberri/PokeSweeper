package org.pokesweeper.model;

public class Tableroa {
	private static Tableroa nireTableroa;

	public BarruLaukia laukia[][];
	
	private int errenkada, zutabe;
	private int minaKop;
	
	
	private Tableroa(){}
	
	public static Tableroa getNireTableroa(){
		if (nireTableroa == null){
			nireTableroa = new Tableroa();
		}
		return nireTableroa;
	}
	
	public void setMinaKop(int pMinaKop) {
		this.minaKop = pMinaKop;
	}
	
	public void setTamaina(int pErrenkada, int pZutabe) {
		this.errenkada = pErrenkada;
		this.zutabe = pZutabe;
	}
	
	public void tableroaEraiki(){
		this.laukia = new BarruLaukia[this.errenkada][this.zutabe];
		for(int erren = 0; erren < this.errenkada; erren++) {
			for(int zut = 0; zut < this.zutabe; zut++) {
				this.laukia[erren][zut] = new BarruLaukia();
			}
		}
		minakJarri();
		zenbakiakJarri();
	}
	
	private void minakJarri() {
		int kont = 0;
		while(this.minaKop != kont) {
			int erren = (int)(Math.random()*this.errenkada-1);
			int zut = (int)(Math.random()*this.zutabe-1);
			if(!this.laukia[erren][zut].isMina()) {
				this.laukia[erren][zut].setMina(true);
				kont++;
			}
		}
	}
	
	private void zenbakiakJarri() {
		for(int erren = 0; erren < this.errenkada; erren++) {
			for(int zut = 0; zut < this.zutabe; zut++) {
				if(!this.laukia[erren][zut].isMina()){
					this.laukia[erren][zut].setZenbakia(zenbakiaKalkulatu(erren, zut));
				}
			}
		}
	}
	
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
	
	/*private boolean aztertutaDago(int pErren, int pZut) {
		return this.laukia[pErren][pZut].isAztertuta();
	}*/
	
}
