package org.pokesweeper.model;

import java.util.ArrayList;

import org.pokesweeper.view.JokoaUI;

public class Tableroa {
	
	//Atributoak
	private static Tableroa nireTableroa;
	private BarruLaukia laukia[][];
	private ArrayList<MinaLaukia> minak;
	public static MinaKontadorea minaKontadorea;
	public static DenboraKontadorea denboraKontadorea;
	private int errenkadaKop;
	private int zutabeKop;
	private int minaKop;
	public int laukiFalta;
	
	//Eraikitzailea
	private Tableroa(){}
	
	public static Tableroa getNireTableroa(){
		if (nireTableroa == null){
			nireTableroa = new Tableroa();
			Tableroa.denboraKontadorea = new DenboraKontadorea();
			Tableroa.minaKontadorea = new MinaKontadorea();
		}
		return nireTableroa;
	}
	
	//Beste Metodoak	
	public void tableroaEraiki(int pErrenkada, int pZutabe, int pMinaKop, boolean pBichilloak){
		this.errenkadaKop = pErrenkada;
		this.zutabeKop = pZutabe;
		this.minaKop = pMinaKop;
		Tableroa.minaKontadorea.minaKopuruaJarri(this.minaKop);
		this.laukiFalta = this.errenkadaKop * this.zutabeKop;
		this.laukia = new BarruLaukia[this.errenkadaKop][this.zutabeKop];
		this.minak = new ArrayList<MinaLaukia>();
		LaukiFactory factory = LaukiFactory.getNireFactory();
		factory.setTamaina(this.errenkadaKop, this.zutabeKop, this.minaKop);
		for(int erren = 0; erren < this.errenkadaKop; erren++) {
			for(int zut = 0; zut < this.zutabeKop; zut++) {
				this.laukia[erren][zut] = factory.createLaukia(erren, zut, pBichilloak);
			}
		}
	}
	
	public void minakBistaratu(){
		for(MinaLaukia auxMina: this.minak){
			auxMina.bistaratu();
		}
		JokoaUI.galdu();
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
	
	public void minaGehitu(MinaLaukia pMinaLaukia) {
		minak.add(pMinaLaukia);
	}
	
	public void irabaziDu(){
		Tableroa tableroa = Tableroa.getNireTableroa();
		tableroa.laukiFalta--;
		if(tableroa.laukiFalta == tableroa.getMinaKop()){
			JokoaUI.irabazi();
		}
	}
	
	public BarruLaukia getLaukiBat(int pErrenkada, int pZutabe){
		return this.laukia[pErrenkada][pZutabe];
	}
	
	//JUnitentzako
	public void setMinaKop(int pMinaKop){
		this.minaKop = pMinaKop;
	}
	
}
