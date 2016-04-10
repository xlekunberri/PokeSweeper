package org.pokesweeper.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.pokesweeper.model.Helbideak;
import org.pokesweeper.model.Ranking;

public class RankingUI extends JDialog {
	
	//Atributuak
	private static final long serialVersionUID = 1L;

	//Eraikitzailea
	public RankingUI(JFrame frame, boolean m){
		super(frame, m);
		setTitle("Pokésweeper - Ranking");
		setPreferredSize(new Dimension(450, 560));
		setResizable(false);
        
        JPanel panela = new JPanel(new GridLayout(2, 1));
        JPanel goikoa = new JPanel(new GridLayout(1, 3));
        
        JButton hooh = new JButton(Helbideak.hooh);
        hooh.setBorder(null);
        hooh.setContentAreaFilled(false);
        hooh.setFocusable(false);
        goikoa.add(hooh);
        
        JButton win = new JButton(Helbideak.win);
        win.setBorder(null);
        win.setContentAreaFilled(false);
        win.setRolloverIcon(Helbideak.win);
        win.setFocusable(false);
        goikoa.add(win);
        
        JButton lugia = new JButton(Helbideak.lugia);
        lugia.setBorder(null);
        lugia.setContentAreaFilled(false);
        lugia.setFocusable(false);
        goikoa.add(lugia);
        
        panela.add(goikoa);
      
        JTabbedPane erlaitzak = new JTabbedPane();
        
        JPanel maila1 = this.mailaLortu(1);
        erlaitzak.addTab("1. Maila", maila1);
 
        JPanel maila2 = this.mailaLortu(2);
        erlaitzak.addTab("2. Maila", maila2);

        JPanel maila3 = this.mailaLortu(3);
        erlaitzak.addTab("3. Maila", maila3);
        
        panela.add(erlaitzak);
        
        add(panela);
		setAlwaysOnTop(true);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
    }
	
	//Beste metodoak
	private JPanel mailaLortu(int pMaila){
       JPanel panela = new JPanel(new GridLayout(5, 2));
       String[] rankinga = Ranking.getNireRanking().rankingLortu(pMaila);
       for(int i = 0; i < rankinga.length; i++){
    	   JPanel panelaAux = new JPanel();
    	   JButton domina = new JButton(Helbideak.dominak[i]);
    	   domina.setBorder(null);
    	   domina.setContentAreaFilled(false);
    	   domina.setFocusable(false);
    	   panelaAux.add(domina);
    	   panelaAux.add(new JLabel(rankinga[i]));
    	   panela.add(panelaAux);
       }
       return panela;
	}
	
}
