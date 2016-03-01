package org.pokesweeper.model;

import org.pokesweeper.view.TableroaUI;

public class Tableroa {
	private int minaKop;
	public BarruLaukia laukia[][];
	private static Tableroa nireTableroa;
	
	private Tableroa(){
		this.tableroaEraiki();
	}
	
	public static Tableroa getNireTableroa(){
		if (nireTableroa == null){
			nireTableroa = new Tableroa();
		}
		return nireTableroa;
	}
	
	private void tableroaEraiki(){
		
	}
	
	public void setMinaKop(int pMinaKop) {
		this.minaKop = pMinaKop;
	}
}
