package org.pokesweeper.model;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;

import org.pokesweeper.view.LaukiaUI;

public class LaukiFactory {
	
	//Atributoak
	private static LaukiFactory nireFactory;
	private int errenkadaKop;
	private int zutabeKop;
	private int minaKop;
	private int[][] minak;
		// 0 = LurLauki
		// 1-8 = ZenbLauki
		// 9 = MinaLauki
	
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
        laukia.setBorder(BorderFactory.createEmptyBorder());
        laukia.setContentAreaFilled(false);
        laukia.setBorderPainted(false);
        laukia.setMargin(new Insets(0, 0, 0, 0));
        laukia.setPreferredSize(new Dimension(32, 32));
        laukia.addMouseListener(laukia);
        //TODO: FALTA PONERLE EL ICONO!
        laukia.repaint();
		return laukia;
	}
	
	public BarruLaukia createLaukiLogikoa(int pErrenkada, int pZutabe){
		this.errenkada = pErrenkada;
		this.zutabe = pZutabe;
		BarruLaukia laukia;
		int ikonoZenb = barrukoZenbLortu();
		int egungoa = this.minak[pErrenkada][pZutabe];
		if(egungoa == 0){
			laukia = new LurLaukia(this.errenkada, this.zutabe, ikonoZenb);
		} else if (egungoa == 9){
			laukia = new MinaLaukia(this.errenkada, this.zutabe, ikonoZenb);
		} else {
			laukia = new ZenbLaukia(this.errenkada, this.zutabe, ikonoZenb, egungoa);
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
			if(this.minak[errenkada][zutabea] != 9){
				this.minak[errenkada][zutabea] = 9;
				albokoakAbisatu(errenkada, zutabea);
				i++;
				
			}
		}
	}
	
	private void albokoakAbisatu(int pErrenkada, int pZutabe){
		for (int y = pZutabe-1; y <= pZutabe + 1; y++){
			for(int x = pErrenkada - 1; x <= pErrenkada + 1; x++ ){
				if (koordenadaEgokiak(x,y) && !(this.errenkada == x && this.zutabe == y) ){
					this.minak[x][y] += 1;
				}
			}
		}
	}
	
	private boolean koordenadaEgokiak(int pErrenkada, int pZutabe){
		if (pErrenkada < 0 || pErrenkada >= this.errenkadaKop || pZutabe < 0 || pZutabe >= this.zutabeKop){
			return false;
		}
		else{
			return true;
		}
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
