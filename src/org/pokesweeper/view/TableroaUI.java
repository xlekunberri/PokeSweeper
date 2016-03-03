package org.pokesweeper.view;

import org.pokesweeper.model.LaukiFactory;
import org.pokesweeper.model.Tableroa;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class TableroaUI extends JPanel{
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	private int errenkada;
	private int zutabe;
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
		this.errenkada = tableroLogikoa.getErrenkadaKop();
		this.zutabe = tableroLogikoa.getZutabeKop();
									  //(errenkadaKopurua, zutabeKopurua) -- GridLayout 
		GridLayout grid = new GridLayout(this.errenkada+2, this.zutabe+2, 0, 0);
		this.setLayout(grid);
		this.laukia = new LaukiaUI[this.errenkada][this.zutabe];
		tableroaEraiki();
	}
	
	//Beste metodoak
	private void tableroaEraiki() {
		LaukiFactory factory = LaukiFactory.getNireFactory();
		this.add(factory.createKanpoLaukia(0));
		for(int zut = 0; zut < this.zutabe; zut++) {
			this.add(factory.createKanpoLaukia(1));
		}
		this.add(factory.createKanpoLaukia(2));
		for(int erren = 0; erren < this.errenkada; erren++) {
			this.add(factory.createKanpoLaukia(3));
			for(int zut = 0; zut < this.zutabe; zut++) {
				this.laukia[erren][zut] = factory.createLaukiUI(erren, zut);
				this.add(this.laukia[erren][zut]);
			}
			this.add(factory.createKanpoLaukia(5));
		}	
		this.add(factory.createKanpoLaukia(6));
		for(int zut = 0; zut < this.zutabe; zut++) {
			this.add(factory.createKanpoLaukia(7));
		}
		this.add(factory.createKanpoLaukia(8));
	}

}