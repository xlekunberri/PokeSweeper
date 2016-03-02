package org.pokesweeper.view;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import org.pokesweeper.model.Helbideak;

public class KanpoLaukiaUI extends JButton{

	private static final long serialVersionUID = 1L;

	public KanpoLaukiaUI(int pPosizioa) {
		this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setPreferredSize(new Dimension(32, 32));
		this.setIcon(Helbideak.lurra[pPosizioa]);	
	}
}
