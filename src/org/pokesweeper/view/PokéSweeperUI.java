package org.pokesweeper.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.pokesweeper.model.Helbideak;

public class PokéSweeperUI extends JFrame{

	//Atributuak
	private static final long serialVersionUID = 1L;
	private static PokéSweeperUI nirePokéSweeperUI = null;
	private JPanel egungoPanela;
	
	//Eraikitzailea
	public static PokéSweeperUI getNirePokéSweeperUI(){
		if(nirePokéSweeperUI == null){
			nirePokéSweeperUI = new PokéSweeperUI();
		}
		return nirePokéSweeperUI;
	}
	
	private PokéSweeperUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("PokéSweeper");
		this.setIconImage(Helbideak.ikonoa);
		this.setCursor(Helbideak.kursorea);
		UIManager.put("Menu.font", Helbideak.iturria);
		UIManager.put("MenuItem.font", Helbideak.iturria);
	}
	
	//Beste metodoak
	public void panelaAldatu(JPanel pPanela){
		if(egungoPanela != null){
			getContentPane().remove(egungoPanela);
		}
		egungoPanela = pPanela;
		this.add(pPanela);
		this.pack();
		this.setVisible(true);
	}
	
	public JPanel panelaLortu(){
		return this.egungoPanela;
	}
	
	public void menuaJarri(){
		this.setJMenuBar(new MenuaUI());
	}
	
	public void menuaKendu(){
		this.setJMenuBar(null);
	}
	
}
