package org.pokesweeper.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import org.pokesweeper.model.Tableroa;

public class TableroaUI extends JPanel{
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	public LaukiaUI laukia[][];
	private static TableroaUI nireTableroUI;
	private final Tableroa tableroLogikoa = Tableroa.getNireTableroa();

	//Eraikitzailea
	private TableroaUI() {
		this.setBackground(new Color(160, 224, 192));	
	}
	
	public static TableroaUI getNireTableroaUI(){
		if (nireTableroUI == null){
			nireTableroUI = new TableroaUI();
		}
		return nireTableroUI;
	}
	
	//Beste metodoak
	public void tableroaEraiki() {
		int errenkada = tableroLogikoa.getErrenkadaKop();
		int zutabe = tableroLogikoa.getZutabeKop();
		this.laukia = new LaukiaUI[errenkada][zutabe];
		this.removeAll();
									  
		GridLayout grid = new GridLayout(errenkada+2, zutabe+2, 0, 0);
		this.setLayout(grid);
		
		this.add(new KanpoLaukiaUI(0));
		for(int zut = 0; zut < zutabe; zut++) {
			this.add(new KanpoLaukiaUI(1));
		}
		this.add(new KanpoLaukiaUI(2));
		for(int erren = 0; erren < errenkada; erren++) {
			this.add(new KanpoLaukiaUI(3));
			for(int zut = 0; zut < zutabe; zut++) {
				this.laukia[erren][zut] =  new LaukiaUI(erren, zut);
				this.add(this.laukia[erren][zut]);
			}
			this.add(new KanpoLaukiaUI(5));
		}	
		this.add(new KanpoLaukiaUI(6));
		for(int zut = 0; zut < zutabe; zut++){
			this.add(new KanpoLaukiaUI(7));
		}
		this.add(new KanpoLaukiaUI(8));
	}

}