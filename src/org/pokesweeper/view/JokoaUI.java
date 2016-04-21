package org.pokesweeper.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.pokesweeper.model.Helbideak;
import org.pokesweeper.model.Pika;
import org.pokesweeper.model.Ranking;
import org.pokesweeper.model.Tableroa;

public class JokoaUI extends JPanel{
	
	//Atributoak
	private static JokoaUI nirejokoa;
	private static final long serialVersionUID = 1L;
	public static boolean bukatuta = false;
	private static JPanel goikoPanela;
	private static JPanel behekoPanela;
	public static KontadoreaUI minaKontadorea;
	public static KontadoreaUI denboraKontadorea;
	public static String erabiltzailea;
	public static int maila;
	
	//Eraikitzailea
	public static JokoaUI getNireJokoa(){
		if (nirejokoa == null){
			nirejokoa = new JokoaUI();
		}
		return nirejokoa;
	}
	
	private JokoaUI(){
		this.setLayout(new BorderLayout());
		goikoPanela = goikoPanelaEraiki();
		add(goikoPanela, BorderLayout.NORTH);
		behekoPanela = behekoPanelakEraiki();
		add(behekoPanela, BorderLayout.CENTER);
		PokéSweeperUI.getNirePokéSweeperUI().panelaAldatu(this);
	}
	
	//Beste metodoak
	private JPanel goikoPanelaEraiki() {
		JPanel goikoPanela = new JPanel(new FlowLayout()); 
		goikoPanela.setBackground(new Color(112, 200, 160));
		
		JPanel goikoPanelaGoian = new JPanel();
		goikoPanelaGoian.setBackground(new Color(112, 200, 160));
		goikoPanela.add(goikoPanelaGoian, BorderLayout.NORTH);
		
		goikoPanela.add(this.getLorea());
		goikoPanela.add(JokoaUI.minaKontadorea = new KontadoreaUI());
		goikoPanela.add(this.getLorea());
		JPanel goian = new JPanel();
		goian.setBackground(new Color(112, 200, 160));
		goikoPanela.add(goian);
		goikoPanela.add(PikaUI.getNirePika());
		JPanel behean = new JPanel();
		behean.setBackground(new Color(112, 200, 160));
		goikoPanela.add(behean);
		goikoPanela.add(this.getLorea());
		goikoPanela.add(JokoaUI.denboraKontadorea = new KontadoreaUI());
		goikoPanela.add(this.getLorea());	
		
		return goikoPanela;
	}
	
	private JPanel behekoPanelakEraiki() {
		JPanel behekoPanela = new JPanel(new BorderLayout());
		setBackground(new Color(112, 200, 160));
		
		JPanel panelIpar = new JPanel();
		panelIpar.setBackground(new Color(112, 200, 160));
		behekoPanela.add(panelIpar, BorderLayout.NORTH);
		
		JPanel panelMendebal = new JPanel();
		panelMendebal.setBackground(new Color(112, 200, 160));
		behekoPanela.add(panelMendebal, BorderLayout.WEST);
		
		JPanel panelEkial = new JPanel();
		panelEkial.setBackground(new Color(112, 200, 160));
		behekoPanela.add(panelEkial, BorderLayout.EAST);
		
		JPanel panelHegoal = new JPanel();
		panelHegoal.setBackground(new Color(112, 200, 160));
		behekoPanela.add(panelHegoal, BorderLayout.SOUTH);
		
		Tableroa.getNireTableroa().tableroaEraiki(7, 10, 0, true);
		TableroaUI.getNireTableroaUI().tableroaEraiki();
		behekoPanela.add(TableroaUI.getNireTableroaUI());
		
		return behekoPanela;
	}
	
	private JLabel getLorea(){
		return new JLabel(Helbideak.lorea);
	}
	
	public static void galdu(){
		JokoaUI.bukatuta = true;
		Tableroa.getNireTableroa().denboraKontadorea.denboraGelditu();
		Pika.getNirePika().setPikaEgoera("galdu");
	}
	
	public static void irabazi(){
		JokoaUI.bukatuta = true;
		Tableroa.getNireTableroa().denboraKontadorea.denboraGelditu();
		Pika.getNirePika().setPikaEgoera("irabazi");
		Ranking.getNireRanking().idatzi(JokoaUI.erabiltzailea, Tableroa.getNireTableroa().denboraKontadorea.getKont());
	}
	
	private void erreseteatu(int pErrenkada, int pZutabe, int pMinaKop, boolean pBichilloak) {
		JokoaUI.behekoPanela.remove(TableroaUI.getNireTableroaUI());
		Tableroa.getNireTableroa().tableroaEraiki(pErrenkada, pZutabe, pMinaKop, pBichilloak);
		TableroaUI.getNireTableroaUI().tableroaEraiki();
		JokoaUI.bukatuta = false;
		JokoaUI.behekoPanela.add(TableroaUI.getNireTableroaUI());
		Pika.getNirePika().setPikaEgoera("normal");
		Tableroa.getNireTableroa().denboraKontadorea.denboraErreseteatu();
		PokéSweeperUI.getNirePokéSweeperUI().panelaAldatu(this);
		PokéSweeperUI.getNirePokéSweeperUI().setLocationRelativeTo(null);
	}
	
	public void erreseteatu(int pMaila, boolean pBichilloak) {
		switch (pMaila) {
		case 1:
        	JokoaUI.maila = 1;
        	erreseteatu(7, 10, 7, pBichilloak);
			break;
		case 2:
        	JokoaUI.maila = 2;
        	erreseteatu(10, 15, 20, pBichilloak);
			break;
		case 3:
        	JokoaUI.maila = 3;
        	erreseteatu(12, 25, 36, pBichilloak);
			break;
		}
	}
	
   public String getUserName(){
    	String username = erabiltzailea;
    	if (username.length()<=10){
    		username = username.substring(0, username.length());
    	}
    	else {
    		username = username.substring(0, 10);
    	}
    	return username;
    }
   
   //JUnitentzako
   public void setMaila(int pMaila){
	   JokoaUI.maila = pMaila;
   }

}
