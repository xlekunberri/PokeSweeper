package org.pokesweeper.model;

public abstract class Kontadorea {
	
	//Atributoak
	protected int kont;
	
	//Eraikitzailea
	public Kontadorea(){
		this.kont = 0;
	}
	
	//Beste metodoak
	protected void kontadoreaEguneratu(){}

	public int getKont() {
		return this.kont;
	}
	
}
