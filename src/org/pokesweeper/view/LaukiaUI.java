package org.pokesweeper.view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;

import org.pokesweeper.model.Helbideak;
import org.pokesweeper.model.Tableroa;

public class LaukiaUI extends JButton implements MouseListener {
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	private final int errenkada;
	private final int zutabe;
	
	//Eraikitzailea
	public LaukiaUI(int pErrenkada, int pZutabe) {
		this.errenkada = pErrenkada;
		this.zutabe = pZutabe;
	}
	
	public void createLaukiUI(){
		this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setPreferredSize(new Dimension(32, 32));
        this.addMouseListener(this);
        this.setIcon(kalkulatuIrudia(this.errenkada, this.zutabe));
        this.repaint();
	}
	
	private Icon kalkulatuIrudia(int pErrenkada, int pZutabea) {
		System.out.println(pErrenkada + " " + pZutabea);
		Icon ikonoa;
		if(pErrenkada == 0) {
			if(pZutabea == 0) {
				ikonoa = Helbideak.belar_normal[0];
			}
			else if(pZutabea == Tableroa.getNireTableroa().getZutabeKop()-1){
				ikonoa = Helbideak.belar_normal[2];
			}
			else {
				ikonoa = Helbideak.belar_normal[1];
			}
		}
		else if (pErrenkada == Tableroa.getNireTableroa().getErrenkadaKop()-1) {
			if(pZutabea == 0) {
				ikonoa = Helbideak.belar_normal[6];
			}
			else if(pZutabea == Tableroa.getNireTableroa().getZutabeKop()-1){
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
			else if(pZutabea == Tableroa.getNireTableroa().getZutabeKop()-1){
				ikonoa = Helbideak.belar_normal[5];
			}
			else {
				ikonoa = Helbideak.belar_normal[4];
			}
		}
		return ikonoa;
	}

	//Beste metodoak
	@Override
	public void mouseClicked(MouseEvent e) {
		//Ezkerra = true
		//Eskuma = false
		if(e.getButton() == MouseEvent.BUTTON1){
			Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mouseClicked(true);	
    	} 
    	else if(e.getButton() == MouseEvent.BUTTON3){
    		Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mouseClicked(false);	
    	}
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mouseEntered();		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mouseExited();		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mousePressed();	
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mouseReleased();	
	}

}
