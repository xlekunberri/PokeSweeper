package org.pokesweeper.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class TableroaUI extends JPanel{
	
	/**
	 * Atributoak
	 */
	private static final long serialVersionUID = 1L;
	
	private int errenkada;
	private int zutabe;
	
	private final int laukiTamaina = 32;
	private LaukiaUI laukiak[][];

	public TableroaUI(int pErrenkada, int pZutabe) {
		this.setBackground(new Color(160, 224, 192)); //0-255	
		this.errenkada = pErrenkada + 2;
		this.zutabe = pZutabe + 2;
		//								(errenkadaKopurua, zutabeKopurua) -- GridLayout 
		GridLayout grid = new GridLayout(this.errenkada, this.zutabe, 0, 0);
		this.setLayout(grid);
		this.setMaximumSize(new Dimension(this.zutabe * this.laukiTamaina, this.errenkada * laukiTamaina));
		this.laukiak = new LaukiaUI[this.errenkada][this.zutabe];
		tableroaEraiki();
	}
	
	private void tableroaEraiki() {
	  
	}
}