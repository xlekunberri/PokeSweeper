package org.pokesweeper.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import org.pokesweeper.view.JokoaUI;
 
public class DenboraKontadorea extends Kontadorea{
	//Atributuak
	private Timer timer;
	
	//Eraikitzailea
	public DenboraKontadorea() {
    	ActionListener actListner = new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent event) {
	   			if (Tableroa.getNireTableroa().denboraKontadorea != null){
	   				kont += 1;
	   				kontadoreaEguneratu();
	   			}
	   		}
    	};
    	timer = new Timer(1000, actListner);
    	timer.start();
    }
	
	//Beste metodoak
	protected void kontadoreaEguneratu(){
		int ehunekoa = this.kont/100;
		int hamarrekoa = (this.kont%100)/10;
		int batekoa = (this.kont%100) % 10;
		JokoaUI.denboraKontadorea.kontadoreaEguneratu(ehunekoa, hamarrekoa, batekoa);
		if (kont==999){
			JokoaUI.galdu();
		}
	}
	
	public void denboraGelditu(){
		timer.stop();
	}
	
	public void denboraErreseteatu(){
		kont = 0;
		kontadoreaEguneratu();
		timer.start();
	}
	
	public int getKont() {
		return this.kont;
	}
	
}
