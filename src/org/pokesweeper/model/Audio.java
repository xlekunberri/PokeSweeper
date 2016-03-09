package org.pokesweeper.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Audio {
	
	//Atributuak
	private static Audio nireAudio;

	//Eraikitzailea
	private Audio(){
		
	}
	
	public static Audio getNireAudio(){
		if(nireAudio == null){
			nireAudio = new Audio();
		}
		return nireAudio;
	}
	
	//Beste metodoak
	public void playAudio(Media pMedia){
		MediaPlayer player = new MediaPlayer(pMedia);
		player.play();
		Duration duration = player.getTotalDuration();
		player.setStopTime(duration);
	}
}