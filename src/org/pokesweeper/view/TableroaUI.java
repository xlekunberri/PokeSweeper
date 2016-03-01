package org.pokesweeper.view;

import org.pokesweeper.model.LaukiFactory;
import org.pokesweeper.model.Tableroa;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class TableroaUI extends JPanel{
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	private int errenkada;
	private int zutabe;
	private final int laukiTamaina = 32;
	public LaukiaUI laukia[][];
	private static TableroaUI helbidea;
	private Tableroa tableroLogikoa = Tableroa.getNireTableroa();

	//Eraikitzailea
	public static TableroaUI getNireTableroaUI(){
		if (helbidea == null){
			helbidea = new TableroaUI();
		}
		return helbidea;
	}

	private TableroaUI() {
		this.setBackground(new Color(160, 224, 192));	
		this.errenkada = tableroLogikoa.getErrenkadaKop() + 2;
		this.zutabe = tableroLogikoa.getZutabeKop() + 2;
									  //(errenkadaKopurua, zutabeKopurua) -- GridLayout 
		GridLayout grid = new GridLayout(this.errenkada, this.zutabe, 0, 0);
		this.setLayout(grid);
		this.setMaximumSize(new Dimension(this.zutabe * this.laukiTamaina, this.errenkada * laukiTamaina));
		this.laukia = new LaukiaUI[this.errenkada][this.zutabe];
		tableroaEraiki();
	}
	
	//Beste metodoak
	private void tableroaEraiki() {
		LaukiFactory factory = LaukiFactory.getNireFactory();
		for(int erren = 0; erren < this.errenkada; erren++) {
			for(int zut = 0; zut < this.zutabe; zut++) {
				this.laukia[erren][zut] = factory.createLaukiUI(erren, zut);
			}
		}			  
	}

}