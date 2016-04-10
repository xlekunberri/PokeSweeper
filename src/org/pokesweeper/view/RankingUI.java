package org.pokesweeper.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.pokesweeper.model.Helbideak;
import org.pokesweeper.model.Ranking;

public class RankingUI extends JFrame {
	
	//Atributuak
	private static final long serialVersionUID = 1L;

	//Eraikitzailea
	public RankingUI(){
		this.setResizable(false);
		this.setPreferredSize(new Dimension(325, 400));
        this.setIconImage(Helbideak.ikonoa);
		this.setCursor(Helbideak.kursorea);
        this.setTitle("Pokésweeper - Ranking");
      
        JTabbedPane erlaitzak = new JTabbedPane();
        
        JPanel maila1 = this.mailaLortu(1);
        erlaitzak.addTab("1. Maila", maila1);
 
        JPanel maila2 = this.mailaLortu(2);
        erlaitzak.addTab("2. Maila", maila2);

        JPanel maila3 = this.mailaLortu(3);
        erlaitzak.addTab("3. Maila", maila3);
        
        getContentPane().add(erlaitzak);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		this.setVisible(true);
		this.pack();
    }
	
	//Beste metodoak
	private JPanel mailaLortu(int pMaila){
       JPanel panela = new JPanel(new GridLayout(10, 1));
       String[] rankinga = Ranking.getNireRanking().rankingLortu(pMaila);
       JLabel[] jLabel = new JLabel[rankinga.length];
       for(int i = 0; i < rankinga.length; i++){
    	   jLabel[i] = new JLabel(rankinga[i]);
    	   panela.add(jLabel[i]);
       }
       return panela;
	}
	
}
