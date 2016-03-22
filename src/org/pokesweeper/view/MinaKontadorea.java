package org.pokesweeper.view;

public class MinaKontadorea extends Kontadorea{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MinaKontadorea(){
		super();
	}
	
	public void kontadoreaErreseteatu() {
		this.kont = 0;
		this.kontadoreaEguneratu();
	}
	
	public void kontadoreaGehitu() {
		this.kont++;
		this.kontadoreaEguneratu();
	}
	
	public void kontadoreaKendu(){
		this.kont--;
		this.kontadoreaEguneratu();
	}
	public void zenbakiaJarri(int pZenbakia){
		this.kont = pZenbakia;
		this.kontadoreaEguneratu();
	}

}
