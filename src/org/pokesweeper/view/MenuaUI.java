package org.pokesweeper.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Box;

public class MenuaUI extends JMenuBar{
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	private JMenuItem berria, maila1, maila2, maila3;
	private JMenuItem irten, nolaJokatu;
	
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
		
		berria = new JMenuItem("Berria");
		jokatu.add(berria);
		
		jokatu.addSeparator();
		
		maila1 = new JMenuItem("1. maila");
		jokatu.add(maila1);
		//maila1.addActionListener(this);
		
		maila2 = new JMenuItem("2. maila");
		jokatu.add(maila2);
		//maila2.addActionListener(this);
		
		maila3 = new JMenuItem("3. maila");
		jokatu.add(maila3);
		//maila3.addActionListener(this);
		
		jokatu.addSeparator();
		
		irten = new JMenuItem("Irten");
		jokatu.add(irten);
		//irten.addActionListener(this);
		
		JMenu laguntza = new JMenu("Laguntza");
		this.add(laguntza);
		
		nolaJokatu = new JMenuItem("Nola jokatu?");
		laguntza.add(nolaJokatu);
		
		laguntza.addSeparator();
		
		JMenuItem mntmHoniBuruz = new JMenuItem("Honi buruz");
		laguntza.add(mntmHoniBuruz);
	}
}
