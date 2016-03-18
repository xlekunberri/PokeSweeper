package org.pokesweeper.view;

import javax.swing.JButton;

import org.pokesweeper.model.Helbideak;

public class KanpoLaukiaUI extends JButton{

	private static final long serialVersionUID = 1L;

	public KanpoLaukiaUI(int pPosizioa) {
		super(Helbideak.lurra[pPosizioa]);
		this.setBorder(null);
        this.setContentAreaFilled(false);
	}
}
