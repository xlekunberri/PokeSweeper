package org.pokesweeper.model;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Helbideak {

	public static Font iturria;
	public static Font unownIturria;
	public static Image ikonoa;
	public static Cursor kursorea;
	
	public static Icon pikaNormal;
	public static Icon pikaIrabazi;
	public static Icon pikaGaldu;
	public static Icon pikaKlik;
	
	public static Icon voltorb;
	
	public static Icon[] lurra = new Icon[9];
	private static Icon lurra_1;
	private static Icon lurra_2;
	private static Icon lurra_3;
	private static Icon lurra_4;
	private static Icon lurra_5;
	private static Icon lurra_6;
	private static Icon lurra_7;
	private static Icon lurra_8;
	private static Icon lurra_9; 
	
	public static Icon[] belar_normal = new Icon[9];
	private static Icon belar_normal_1;
	private static Icon belar_normal_2;
	private static Icon belar_normal_3;
	private static Icon belar_normal_4;
	private static Icon belar_normal_5;
	private static Icon belar_normal_6;
	private static Icon belar_normal_7;
	private static Icon belar_normal_8;
	private static Icon belar_normal_9;
	
	public static Icon[] belar_mugimendu = new Icon[9];
	private static Icon belar_mugimendu_1;
	private static Icon belar_mugimendu_2;
	private static Icon belar_mugimendu_3;
	private static Icon belar_mugimendu_4;
	private static Icon belar_mugimendu_5;
	private static Icon belar_mugimendu_6;
	private static Icon belar_mugimendu_7;
	private static Icon belar_mugimendu_8;
	private static Icon belar_mugimendu_9;
	
	public static Icon[] zenbaki = new Icon[8];
	private static Icon zenbaki_1;
	private static Icon zenbaki_2;
	private static Icon zenbaki_3;
	private static Icon zenbaki_4;
	private static Icon zenbaki_5;
	private static Icon zenbaki_6;
	private static Icon zenbaki_7;
	private static Icon zenbaki_8;
	
	public static void denakKargatu(){
		Helbideak.besteakKargatu();
		Helbideak.belarraKargatu();
		Helbideak.lurraKargatu();
		Helbideak.mugimenduaKargatu();
		Helbideak.pikaKargatu();
		Helbideak.zenbakiakKargatu();
	}
	
	private static void besteakKargatu(){
		try{
			iturria = (Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("src/skin/font/normala.ttf"))).deriveFont(12F);
			unownIturria = (Font.createFont( Font.TRUETYPE_FONT, new FileInputStream("src/skin/font/unown.ttf"))).deriveFont(12F);
			ikonoa = ImageIO.read(new File("src/skin/ikonoa.png"));
			kursorea = Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("src/skin/kursorea.png") , new Point(3, 30), "img");
			//TODO: CARGAR EL VOLTORB!
		}catch (IOException | FontFormatException e){
			 e.printStackTrace();
		}
	}
		
	private static void pikaKargatu(){
		try {
		pikaNormal = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/pika/normal.png")));
		pikaIrabazi = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/pika/irabazi.png")));
		pikaGaldu = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/pika/galdu.png")));
		pikaKlik = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/pika/klik.png")));
		} catch (IOException e) {}
	}
		
	private static void lurraKargatu(){
		try{
			lurra_1 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/lurra/1.png")));
			lurra_2 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/lurra/2.png")));
			lurra_3 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/lurra/3.png")));
			lurra_4 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/lurra/4.png")));
			lurra_5 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/lurra/5.png")));
			lurra_6 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/lurra/6.png")));
			lurra_7 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/lurra/7.png")));
			lurra_8 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/lurra/8.png")));
			lurra_9 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/lurra/9.png")));
		} catch (IOException e) {}
		lurra[0] = lurra_1;
		lurra[1] = lurra_2;
		lurra[2] = lurra_3;
		lurra[3] = lurra_4;
		lurra[4] = lurra_5;
		lurra[5] = lurra_6;
		lurra[6] = lurra_7;
		lurra[7] = lurra_8;
		lurra[8] = lurra_9;		
		
	}
	
	private static void belarraKargatu(){
		try{
			belar_normal_1 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/normala/1.png")));
			belar_normal_2 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/normala/2.png")));
			belar_normal_3 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/normala/3.png")));
			belar_normal_4 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/normala/4.png")));
			belar_normal_5 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/normala/5.png")));
			belar_normal_6 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/normala/6.png")));
			belar_normal_7 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/normala/7.png")));
			belar_normal_8 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/normala/8.png")));
			belar_normal_9 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/normala/9.png")));
		} catch (IOException e) {}
		belar_normal[0] = belar_normal_1;
		belar_normal[1] = belar_normal_2;
		belar_normal[2] = belar_normal_3;
		belar_normal[3] = belar_normal_4;
		belar_normal[4] = belar_normal_5;
		belar_normal[5] = belar_normal_6;
		belar_normal[6] = belar_normal_7;
		belar_normal[7] = belar_normal_8;
		belar_normal[8] = belar_normal_9;
	}
	
	private static void mugimenduaKargatu(){
		try{
			//belar_mugimendu_1 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/mugimendua/1/1.gif")));
			//belar_mugimendu_2 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/mugimendua/2/2.gif")));
			//belar_mugimendu_3 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/mugimendua/3/3.gif")));
			//belar_mugimendu_4 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/mugimendua/4/4.gif")));
			belar_mugimendu_5 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/mugimendua/5/5.gif")));
			//belar_mugimendu_6 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/mugimendua/6/6.gif")));
			//belar_mugimendu_7 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/mugimendua/7/7.gif")));
			//belar_mugimendu_8 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/mugimendua/8/8.gif")));
			//belar_mugimendu_9 = new ImageIcon(ImageIO.read(Helbideak.class.getResource("/skin/belarra/mugimendua/9/9.gif")));
		} catch (IOException e) {}
		belar_mugimendu[0] = belar_mugimendu_1;
		belar_mugimendu[1] = belar_mugimendu_2;
		belar_mugimendu[2] = belar_mugimendu_3;
		belar_mugimendu[3] = belar_mugimendu_4;
		belar_mugimendu[4] = belar_mugimendu_5;
		belar_mugimendu[5] = belar_mugimendu_6;
		belar_mugimendu[6] = belar_mugimendu_7;
		belar_mugimendu[7] = belar_mugimendu_8;
		belar_mugimendu[8] = belar_mugimendu_9;
	}
	
	private static void zenbakiakKargatu(){
		//TODO: CARGAR LOS ZENBAKIZ!
		zenbaki[0] = zenbaki_1;
		zenbaki[1] = zenbaki_2;
		zenbaki[2] = zenbaki_3;
		zenbaki[3] = zenbaki_4;
		zenbaki[4] = zenbaki_5;
		zenbaki[5] = zenbaki_6;
		zenbaki[6] = zenbaki_7;
		zenbaki[7] = zenbaki_8;
	}
}
