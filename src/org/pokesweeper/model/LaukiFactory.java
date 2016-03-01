package org.pokesweeper.model;

import org.pokesweeper.view.LaukiaUI;

public class LaukiFactory {
	
	//Atributoak
	private static LaukiFactory nireFactory;
	private int errenkadaKop;
	private int zutabeKop;
	private int minaKop;
	private boolean[][] minak;
	
	private int errenkada;
	private int zutabe;
	
	//Eraikitzailea
	private LaukiFactory(){
		
	}
		
	public static LaukiFactory getNireFactory(){
		if(nireFactory == null){
			nireFactory = new LaukiFactory();
		}
		return nireFactory;
	}
	
	//Beste metodoak
	public LaukiaUI createLaukiUI(int pErrenkada, int pZutabe){
		this.errenkada = pErrenkada;
		this.zutabe = pZutabe;
		LaukiaUI laukia = new LaukiaUI(pErrenkada, pZutabe);
		return laukia;
	}
	
	public BarruLaukia createLaukiLogikoa(int pErrenkada, int pZutabe){
		this.errenkada = pErrenkada;
		this.zutabe = pZutabe;
		BarruLaukia laukia;
		int ikonoZenb = barrukoZenbLortu();
		int mota = motaLortu();
			// 0 = LurLaukia
			// 1 = ZenbLaukia
			// 2 = MinaLaukia
		if(mota == 1){
			laukia = new LurLaukia(this.errenkada, this.zutabe, ikonoZenb);
		} else if (mota == 2){
			int ingurukoMinak = this.ingurukoMinakLortu();
			laukia = new ZenbLaukia(this.errenkada, this.zutabe, ikonoZenb, ingurukoMinak);
		} else {
			laukia = new MinaLaukia(this.errenkada, this.zutabe, ikonoZenb);
		}
		return laukia;		
	}
	
	public void setTamaina(int pErrenkadaKop, int pZutabeKop, int pMinaKop){
		this.errenkadaKop = pErrenkadaKop;
		this.zutabeKop = pZutabeKop;
		this.minaKop = pMinaKop;
		this.minak = new boolean[this.errenkadaKop][this.zutabeKop];
		this.minakJarri();
	}
	
	private void minakJarri(){
		int i = 0;
		while(i != this.minaKop){
			Integer errenkada = (int)(Math.random()*(this.errenkadaKop));
			Integer zutabea = (int)(Math.random()*(this.zutabeKop));
			if(!this.minak[errenkada][zutabea]){
				this.minak[errenkada][zutabea] = true;
				i++;
			}
		}
	}
	
	private int ingurukoMinakLortu() {
		//TODO
		return 0;
	}

	private int motaLortu(){
		//TODO
		return 0;	
	}
	
	private int barrukoZenbLortu(){
		int zenbakia;
		if(this.errenkada == 1){
			if(this.zutabe == 1){
				zenbakia = 1;
			} else if (this.zutabe != this.zutabeKop - 1){
				zenbakia = 2;
			} else {
				zenbakia = 3;
			}
		} else if(this.errenkada != this.errenkadaKop - 1){
			if(this.zutabe == 1){
				zenbakia = 4;
			} else if (this.zutabe != this.zutabeKop - 1){
				zenbakia = 5;
			} else {
				zenbakia = 6;
			}
		} else {
			if(this.zutabe == 1){
				zenbakia = 7;
			} else if (this.zutabe != this.zutabeKop - 1){
				zenbakia = 8;
			} else {
				zenbakia = 9;
			}
		}
		return zenbakia;
	}

}
