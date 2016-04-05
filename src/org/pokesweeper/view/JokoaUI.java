package org.pokesweeper.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.pokesweeper.model.Helbideak;
import org.pokesweeper.model.Pika;
import org.pokesweeper.model.Tableroa;

public class JokoaUI extends JFrame implements ActionListener{
	
	//Atributoak
	private static JokoaUI nirejokoa;
	private static final long serialVersionUID = 1L;
	private static JPanel behekoPanela;
	public static boolean bukatuta = false;
	public static KontadoreaUI minaKontadorea;
	public static KontadoreaUI denboraKontadorea;
	
	// Main metodoa
	public static void main(String[] args) {
		Helbideak.denakKargatu();
		new Splash();
		JDialog.setDefaultLookAndFeelDecorated(true);
	}
	
	//Eraikitzailea
	private JokoaUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("PokéSweeper");
		this.setIconImage(Helbideak.ikonoa);
		this.setCursor(Helbideak.kursorea);
		UIManager.put("Menu.font", Helbideak.iturria);
		UIManager.put("MenuItem.font", Helbideak.iturria);
		
		this.setJMenuBar(new MenuaUI());
		
		goikoPanelaEraiki();
		
		behekoPanela = new JPanel();
		behekoPanela.setBackground(new Color(112, 200, 160));
		behekoPanela.setLayout(new BorderLayout(0, 0));
		getContentPane().add(behekoPanela, BorderLayout.CENTER);
		
		panelakEraiki();
		
		Tableroa.getNireTableroa().tableroaEraiki(7, 10, 7, false);
		TableroaUI.getNireTableroaUI().tableroaEraiki();
		behekoPanela.add(TableroaUI.getNireTableroaUI());
		
		this.setVisible(true);
		this.pack();
	}
	
	public static JokoaUI getNireJokoa(){
		if (nirejokoa == null){
			nirejokoa = new JokoaUI();
		}
		return nirejokoa;
	}
	
	//Beste metodoak
	private void panelakEraiki() {
		
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
		
	}
	
	private void goikoPanelaEraiki() {
		JPanel goikoPanela = new JPanel(new FlowLayout());
		goikoPanela.setBackground(new Color(112, 200, 160));
		getContentPane().add(goikoPanela, BorderLayout.NORTH);
		
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
	}
	
	private JButton getLorea(){
		JButton lorea = new JButton(Helbideak.lorea);
		lorea.setBorder(null);
		lorea.setContentAreaFilled(false);
		return lorea;
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
	}
	
	public void erreseteatu(int pErrenkada, int pZutabe, int pMinaKop, boolean pBichilloak) {
		JokoaUI.behekoPanela.remove(TableroaUI.getNireTableroaUI());
		Tableroa.getNireTableroa().tableroaEraiki(pErrenkada, pZutabe, pMinaKop, pBichilloak);
		TableroaUI.getNireTableroaUI().tableroaEraiki();
		JokoaUI.bukatuta = false;
		JokoaUI.behekoPanela.add(TableroaUI.getNireTableroaUI());
		Pika.getNirePika().setPikaEgoera("normal");
		Tableroa.getNireTableroa().denboraKontadorea.denboraErreseteatu();
		this.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
