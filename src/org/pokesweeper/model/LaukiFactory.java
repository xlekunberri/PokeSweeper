package org.pokesweeper.model;

public class LaukiFactory {
	
	//Atributoak
	private static LaukiFactory nireFactory;
	private int errenkadaKop;
	private int zutabeKop;
	private int minaKop;
	private int[][] minak; // -1 = MinaLauki, 0 = LurLauki, 1-8 = ZenbLauki
	
	//Eraikitzailea
	private LaukiFactory(){}
		
	public static LaukiFactory getNireFactory(){
		if(nireFactory == null){
			nireFactory = new LaukiFactory();
		}
		return nireFactory;
	}
	
	//Beste metodoak	
	public BarruLaukia createLaukia(int pErrenkada, int pZutabe, boolean pBichilloak){
		BarruLaukia laukia;
		int ikonoZenb = this.zenbakiaLortu(pErrenkada, pZutabe);
		int egungoa = this.minak[pErrenkada][pZutabe];
		if(pBichilloak){
			laukia = new BichilloLaukia(pErrenkada, pZutabe, ikonoZenb);
		} 
		else{
			if(egungoa == 0){
				laukia = new LurLaukia(pErrenkada, pZutabe, ikonoZenb);
			} else if (egungoa == -1){
				laukia = new MinaLaukia(pErrenkada, pZutabe, ikonoZenb);
				Tableroa.getNireTableroa().minak.add((MinaLaukia) laukia);
			} else {
				laukia = new ZenbLaukia(pErrenkada, pZutabe, ikonoZenb, egungoa);
			}	
		}
		return laukia;
	}
	
	public void setTamaina(int pErrenkadaKop, int pZutabeKop, int pMinaKop){
		this.errenkadaKop = pErrenkadaKop;
		this.zutabeKop = pZutabeKop;
		this.minaKop = pMinaKop;
		this.minak = new int[this.errenkadaKop][this.zutabeKop];
		this.minakJarri();
	}
	
	private void minakJarri(){
		int i = 0;
		while(i != this.minaKop){
			Integer errenkada = (int)(Math.random()*(this.errenkadaKop));
			Integer zutabea = (int)(Math.random()*(this.zutabeKop));
			if(this.minak[errenkada][zutabea] != -1){
				this.minak[errenkada][zutabea] = -1;
				albokoakAbisatu(errenkada, zutabea);
				i++;
			}
		}
	}
	
	private void albokoakAbisatu(int pErrenkada, int pZutabe){
		for (int x = pErrenkada-1; x <= pErrenkada + 1; x++){
			for(int y = pZutabe - 1; y <= pZutabe + 1; y++ ){
				if (koordenadaEgokiak(x,y) && !(pErrenkada == x && pZutabe == y) && !(this.minak[x][y] == -1)){
					this.minak[x][y]++;
				}
			}
		}
	}
	
	private boolean koordenadaEgokiak(int pErrenkada, int pZutabe){
		return !(pErrenkada < 0 || pErrenkada >= this.errenkadaKop || pZutabe < 0 || pZutabe >= this.zutabeKop);
	}
	
	private int zenbakiaLortu(int pErrenkada, int pZutabe){
		int zenbakia;
		if(pErrenkada == 0){
			if(pZutabe == 0){
				zenbakia = 0;
			} else if (pZutabe != this.zutabeKop - 1){
				zenbakia = 1;
			} else {
				zenbakia = 2;
			}
		} else if(pErrenkada != this.errenkadaKop - 1){
			if(pZutabe == 0){
				zenbakia = 3;
			} else if (pZutabe != this.zutabeKop - 1){
				zenbakia = 4;
			} else {
				zenbakia = 5;
			}
		} else {
			if(pZutabe == 0){
				zenbakia = 6;
			} else if (pZutabe != this.zutabeKop - 1){
				zenbakia = 7;
			} else {
				zenbakia = 8;
			}
		}
		return zenbakia;
	}

}
