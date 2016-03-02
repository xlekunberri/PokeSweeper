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
		this.add(new KanpoLaukiaUI(0));
		for(int zut = 2; zut < this.zutabe; zut++) {
			this.add(new KanpoLaukiaUI(1));
		}
		this.add(new KanpoLaukiaUI(2));
		for(int erren = 1; erren < this.errenkada - 1; erren++) {
			this.add(new KanpoLaukiaUI(3));
			for(int zut = 1; zut < this.zutabe - 1; zut++) {
				this.laukia[erren][zut] = factory.createLaukiUI(erren, zut);
				this.add(this.laukia[erren][zut]);
			}
			this.add(new KanpoLaukiaUI(5));
		}	
		this.add(new KanpoLaukiaUI(6));
		for(int zut = 2; zut < this.zutabe; zut++) {
			this.add(new KanpoLaukiaUI(7));
		}
		this.add(new KanpoLaukiaUI(8));
	}

}