package org.pokesweeper.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.pokesweeper.model.Helbideak;

public class MenuaUI extends JMenuBar implements ActionListener{
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	private JMenuItem maila1, maila2, maila3;
	private JMenuItem irten, nolaJokatu, honiBuruz;

	
	//Eraikitzailea
	public MenuaUI() {
		this.setBorder(null);
		this.setBackground(new Color(89, 153, 124));
		this.add(Box.createRigidArea(new Dimension(5, 25)));
		menuaEraiki();
	}
	
	//Beste Metodoak
	private void menuaEraiki() {
		
		JMenu jokatu = new JMenu("Jokatu");
		this.add(jokatu);
		
		maila1 = new JMenuItem("1. maila");
		jokatu.add(maila1);
		maila1.addActionListener(this);
		
		maila2 = new JMenuItem("2. maila");
		jokatu.add(maila2);
		maila2.addActionListener(this);
		
		maila3 = new JMenuItem("3. maila");
		jokatu.add(maila3);
		maila3.addActionListener(this);
		
		jokatu.addSeparator();
		
		irten = new JMenuItem("Irten");
		jokatu.add(irten);
		irten.addActionListener(this);
		
		JMenu laguntza = new JMenu("Laguntza");
		this.add(laguntza);
		
		nolaJokatu = new JMenuItem("Nola jokatu?");
		laguntza.add(nolaJokatu);
		nolaJokatu.addActionListener(this);
		
		laguntza.addSeparator();
		
		honiBuruz = new JMenuItem("Honi buruz");
		laguntza.add(honiBuruz);
		honiBuruz.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	            
	        if (e.getSource()==maila1) {
	        	JokoaUI.getNireJokoa().erreseteatu(7, 10, 1);
	        }
		 	else if (e.getSource()==maila2) {
		 		JokoaUI.getNireJokoa().erreseteatu(10,15,20);
	        }       
		 	else if (e.getSource()==maila3) {
		 		JokoaUI.getNireJokoa().erreseteatu(12,25,36); 
	        }       
		 	else if (e.getSource()==irten) {
		 		UIManager.put("OptionPane.yesButtonText", "Bai");
		 		UIManager.put("OptionPane.noButtonText", "Ez");
		 		UIManager.put("OptionPane.cancelButtonText", "Ezeztatu");
		 		JFrame frame = new JFrame();
		 	    int response = JOptionPane.showConfirmDialog(frame, "Jokoa itxi nahi duzu?","Jokoa itxi",
		 	    		JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,Helbideak.pikaGaldu);
		 	    if (response == JOptionPane.YES_OPTION) {
		 	      System.exit(0);
		 	    }
	        }     
			else if (e.getSource()==nolaJokatu) {
				
			}
			else if (e.getSource()==honiBuruz) {
			}
	}
}
