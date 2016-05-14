package org.pokesweeper.model;

import javax.swing.JDialog;

import org.pokesweeper.view.JokoaUI;
import org.pokesweeper.view.LoginUI;
import org.pokesweeper.view.PokéSweeperUI;
import org.pokesweeper.view.Splash;

import javafx.embed.swing.JFXPanel;
import javafx.util.Duration;

public class PokeSweeper {
	
	//Atributoak
	private static PokeSweeper nirePokéSweeper;
	final JFXPanel jfx;
	private int sLekua = 10;
	
	//Main metodoa
	public static void main(String[] args) {
		PokeSweeper.getNirePokéSweeper();
	}
	
	//Eraikitzailea
	public static PokeSweeper getNirePokéSweeper(){
		if(nirePokéSweeper == null){
			nirePokéSweeper = new PokeSweeper();
		}
		return nirePokéSweeper;
	}
	
	private PokeSweeper(){
		Helbideak.denakKargatu();
		jfx = new JFXPanel();
		this.hurrengoa(0);
		JDialog.setDefaultLookAndFeelDecorated(true);
	}
	
	//Beste metodoak
	public void hurrengoa(int pInt) {
		switch (pInt) {
		case 0:
			this.splash();
			break;
		case 1:
			this.musikaJarri();
			this.login();
			break;
		case 2:
			this.jokoa();
			break;
		}
		
	}
	
	private void splash(){
		new Splash();
	}
	
	public void login(){
		new LoginUI();
	}
	
	private void jokoa(){
		PokéSweeperUI.getNirePokéSweeperUI().menuaJarri();
		JokoaUI.getNireJokoa().erreseteatu(JokoaUI.maila, false);
	}
	
	private void musikaJarri(){
		Audioa intro = new Audioa(Helbideak.intro);
		Audioa.setVolume(PokeSweeper.getNirePokéSweeper().getSLekua());
		intro.play();
		intro.getPlayer().setOnEndOfMedia(new Runnable(){
			@Override
			public void run(){
				final Audioa bucle = new Audioa(Helbideak.bucle);
				Audioa.setVolume(PokeSweeper.getNirePokéSweeper().getSLekua());
				bucle.play();
				bucle.getPlayer().setOnEndOfMedia(new Runnable(){
					@Override
					public void run(){
						bucle.getPlayer().seek(Duration.ZERO);
					}
				});
			}
		});
	}
	
	public void sLekuaAldatu(int i){
		sLekua=i;
	}
	public int getSLekua(){
		return sLekua;
	}


	
}
