package org.pokesweeper.model;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Icon;

import org.pokesweeper.view.KanpoLaukiaUI;
import org.pokesweeper.view.LaukiaUI;

public class LaukiFactory {
	
	//Atributoak
	private static LaukiFactory nireFactory;
	private int errenkadaKop;
	private int zutabeKop;
	private int minaKop;
	private int[][] minak;
		// -1 = MinaLauki
		// 0 = LurLauki
		// 1-8 = ZenbLauki
	
	private int errenkada;
	private int zutabe;
	
	//Eraikitzailea
	private LaukiFactory(){}
		
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
        laukia.setIcon(kalkulatuIrudia(pErrenkada, pZutabe));
        laukia.repaint();
		return laukia;
	}
	
	public BarruLaukia createLaukiLogikoa(int pErrenkada, int pZutabe){
		this.errenkada = pErrenkada;
		this.zutabe = pZutabe;
		BarruLaukia laukia;
		int ikonoZenb = barrukoZenbLortu();
		if (Tableroa.getNireTableroa().lehenengoTxanda()){
			laukia = new BichilloLaukia(this.errenkada, this.zutabe, ikonoZenb);
		}
		else{
			int egungoa = this.minak[pErrenkada][pZutabe];
			if(egungoa == 0){
				laukia = new LurLaukia(this.errenkada, this.zutabe, ikonoZenb);
			} else if (egungoa == -1){
				laukia = new MinaLaukia(this.errenkada, this.zutabe, ikonoZenb);
			} else {
				laukia = new ZenbLaukia(this.errenkada, this.zutabe, ikonoZenb, egungoa);
			}		
		}
		return laukia;
	}
	
	
	public KanpoLaukiaUI createKanpoLaukia(int pZenbakia) {
		return new KanpoLaukiaUI(pZenbakia);
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
	
	private int barrukoZenbLortu(){
		int zenbakia;
		if(this.errenkada == 0){
			if(this.zutabe == 0){
				zenbakia = 0;
			} else if (this.zutabe != this.zutabeKop - 1){
				zenbakia = 1;
			} else {
				zenbakia = 2;
			}
		} else if(this.errenkada != this.errenkadaKop - 1){
			if(this.zutabe == 0){
				zenbakia = 3;
			} else if (this.zutabe != this.zutabeKop - 1){
				zenbakia = 4;
			} else {
				zenbakia = 5;
			}
		} else {
			if(this.zutabe == 0){
				zenbakia = 6;
			} else if (this.zutabe != this.zutabeKop - 1){
				zenbakia = 7;
			} else {
				zenbakia = 8;
			}
		}
		return zenbakia;
	}

	private Icon kalkulatuIrudia(int pErrenkada, int pZutabea) {
		Icon ikonoa;
		if(pErrenkada == 0) {
			if(pZutabea == 0) {
				ikonoa = Helbideak.belar_normal[0];
			}
			else if(pZutabea == this.zutabeKop-1){
				ikonoa = Helbideak.belar_normal[2];
			}
			else {
				ikonoa = Helbideak.belar_normal[1];
			}
		}
		else if (pErrenkada == this.errenkadaKop-1) {
			if(pZutabea == 0) {
				ikonoa = Helbideak.belar_normal[6];
			}
			else if(pZutabea == this.zutabeKop-1){
				ikonoa = Helbideak.belar_normal[8];
			}
			else {
				ikonoa = Helbideak.belar_normal[7];
			}
		}
		else {
			if(pZutabea == 0) {
				ikonoa = Helbideak.belar_normal[3];
			}
			else if(pZutabea == this.zutabeKop-1){
				ikonoa = Helbideak.belar_normal[5];
			}
			else {
				ikonoa = Helbideak.belar_normal[4];
			}
		}
		return ikonoa;
	}
}
