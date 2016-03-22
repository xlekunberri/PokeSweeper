package org.pokesweeper.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
 
public class DenboraKontadorea extends Kontadorea {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	
	public DenboraKontadorea() {
    	ActionListener actListner = new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent event) {
    			if (JokoaUI.denboraKontadorea!=null){
    				kont += 1;
    				kontadoreaEguneratu();
    			}
    		}
    	};
    	timer = new Timer(1000, actListner);
    	timer.start();
    }
	public void denboraGelditu(){
		timer.stop();
	}
	public void denboraErreseteatu(){
		kont=0;
		kontadoreaEguneratu();
	}
	
}
