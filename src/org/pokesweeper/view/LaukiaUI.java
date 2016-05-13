package org.pokesweeper.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import org.pokesweeper.model.BarruLaukia;
import org.pokesweeper.model.Helbideak;
import org.pokesweeper.model.Tableroa;

public class LaukiaUI extends JButton implements MouseListener {
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	private final int errenkada;
	private final int zutabe;
	
	//Eraikitzailea
	
	public LaukiaUI(int pErrenkada, int pZutabe){
		//BarruLaukia (belarra daukan laukia)
		this.errenkada = pErrenkada;
		this.zutabe = pZutabe;
		BarruLaukia laukiLogikoa = Tableroa.getNireTableroa().getLaukiBat(pErrenkada, pZutabe);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
        this.addMouseListener(this);
        this.setIcon(Helbideak.belar_normal[laukiLogikoa.getIkonoZenb()]);
        this.repaint();
	}
	
	public LaukiaUI(int pPosizioa){
		//KanpoLaukia (lurra daukan laukia)
		super(Helbideak.lurra[pPosizioa]);
		this.errenkada = 0;
		this.zutabe = 0;
		this.setBorder(null);
        this.setContentAreaFilled(false);
	}

	//Beste metodoak
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			Tableroa.getNireTableroa().getLaukiBat(this.errenkada,this.zutabe).ezkerrekoBotoia();
    	} 
    	else if(e.getButton() == MouseEvent.BUTTON3){
    		Tableroa.getNireTableroa().getLaukiBat(this.errenkada,this.zutabe).eskumakoBotoia();	
    	}
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Tableroa.getNireTableroa().getLaukiBat(this.errenkada,this.zutabe).mouseEntered();		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Tableroa.getNireTableroa().getLaukiBat(this.errenkada,this.zutabe).mouseExited();		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			Tableroa.getNireTableroa().getLaukiBat(this.errenkada,this.zutabe).mousePressed();	
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Tableroa.getNireTableroa().getLaukiBat(this.errenkada,this.zutabe).mouseReleased();	
	}

}
