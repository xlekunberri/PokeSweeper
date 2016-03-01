package org.pokesweeper.model;

import javax.swing.ImageIcon;

import org.pokesweeper.view.LaukiaUI;

public class LaukiFactory {
	
	private static LaukiFactory nireFactory;
	private int errenkadaKop;
	private int zutabeKop;
	private int minaKop;
	private boolean[][] minak;
	
	private int errenkada;
	private int zutabe;
	
	
	private LaukiFactory(){
		
	}
		
	public static LaukiFactory getNireFactory(){
		if(nireFactory == null){
			nireFactory = new LaukiFactory();
		}
		return nireFactory;
	}
	
	public void setTamaina(int pErrenkadaKop, int pZutabeKop, int pMinaKop){
		this.errenkadaKop = pErrenkadaKop - 2;
		this.zutabeKop = pZutabeKop - 2;
		this.minaKop = pMinaKop;
		this.minak = new boolean[this.errenkadaKop][this.zutabeKop];
		this.minakJarri();
	}
	
	private void minakJarri(){
		int i = 0;
		while(i != minaKop){
			Integer errenkada = (int)(Math.random()*(this.errenkadaKop));
			Integer zutabea = (int)(Math.random()*(this.zutabeKop));
			if(!this.minak[errenkada][zutabea]){
				this.minak[errenkada][zutabea] = true;
				i++;
			}
		}
	}
	
	public LaukiaUI createLaukia(int pErrenkada, int pZutabe){
		this.errenkada = pErrenkada;
		this.zutabe = pZutabe;
		LaukiaUI laukia = null;
		boolean belarraDa = this.motaLortu();
		if (belarraDa){
			int ikonoZenb = ikonoZenbLortu();
			laukia = new LaukiaUI(0, this.errenkada, this.zutabe, ikonoZenb);
			laukia.setIcon(/*BELARRA*/);
		} else {
			int ikonoZenb = ikonoZenbLortu();
			laukia = new LaukiaUI(3, this.errenkada, this.zutabe, ikonoZenb);
			laukia.setIcon(/*LURRA*/);
		}
		return laukia;		
	}
	
	private boolean motaLortu(){
		boolean belarraDa = true;
		if (this.errenkada == 0 || this.errenkada == this.errenkadaKop || this.zutabe == 0 || this.zutabe == this.zutabeKop){
			belarraDa = false;
		}
		return belarraDa;	
	}
	
	//EN ESTE NO SE HAN TENIDO EN CUENTA LOS LAUKIAK DE FUERA.
	private int ikonoZenbLortu(){
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
	}

}
