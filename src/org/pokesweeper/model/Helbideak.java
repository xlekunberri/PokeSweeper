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
	
	public static Icon lurra_1;
	public static Icon lurra_2;
	public static Icon lurra_3;
	public static Icon lurra_4;
	public static Icon lurra_5;
	public static Icon lurra_6;
	public static Icon lurra_7;
	public static Icon lurra_8;
	public static Icon lurra_9; 
	
	public static Icon belar_normal_1;
	public static Icon belar_normal_2;
	public static Icon belar_normal_3;
	public static Icon belar_normal_4;
	public static Icon belar_normal_5;
	public static Icon belar_normal_6;
	public static Icon belar_normal_7;
	public static Icon belar_normal_8;
	public static Icon belar_normal_9;
	
	public static Icon belar_mugimendu_1;
	public static Icon belar_mugimendu_2;
	public static Icon belar_mugimendu_3;
	public static Icon belar_mugimendu_4;
	public static Icon belar_mugimendu_5;
	public static Icon belar_mugimendu_6;
	public static Icon belar_mugimendu_7;
	public static Icon belar_mugimendu_8;
	public static Icon belar_mugimendu_9;
	
	
	public void besteakKargatu(){
		try{
			iturria = (Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("src/skin/font/normala.ttf"))).deriveFont(12F);
			unownIturria = (Font.createFont( Font.TRUETYPE_FONT, new FileInputStream("src/skin/font/unown.ttf"))).deriveFont(12F);
			ikonoa = ImageIO.read(new File("src/skin/ikonoa.png"));
			kursorea = Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("src/skin/kursorea.png") , new Point(3, 30), "img");
		}catch (IOException | FontFormatException e){
			 e.printStackTrace();
		}
	}
		
	public void pikaKargatu(){
		pikaNormal = new ImageIcon("/skin/pika/normal.png");
		pikaIrabazi = new ImageIcon("/skin/pika/irabazi.png");
		pikaGaldu = new ImageIcon("/skin/pika/galdu.png");
		pikaKlik = new ImageIcon("/skin/pika/klik.png");
	}
		
	public void lurraKargatu(){
		lurra_1 = new ImageIcon("/skin/lurra/1.png");
		lurra_2 = new ImageIcon("/skin/lurra/2.png");
		lurra_3 = new ImageIcon("/skin/lurra/3.png");
		lurra_4 = new ImageIcon("/skin/lurra/4.png");
		lurra_5 = new ImageIcon("/skin/lurra/5.png");
		lurra_6 = new ImageIcon("/skin/lurra/6.png");
		lurra_7 = new ImageIcon("/skin/lurra/7.png");
		lurra_8 = new ImageIcon("/skin/lurra/8.png");
		lurra_9 = new ImageIcon("/skin/lurra/9.png");
	}
	
	public void belarraKargatu(){
		belar_normal_1 = new ImageIcon("/skin/belarra/normala/1.png");
		belar_normal_2 = new ImageIcon("/skin/belarra/normala/2.png");
		belar_normal_3 = new ImageIcon("/skin/belarra/normala/3.png");
		belar_normal_4 = new ImageIcon("/skin/belarra/normala/4.png");
		belar_normal_5 = new ImageIcon("/skin/belarra/normala/5.png");
		belar_normal_6 = new ImageIcon("/skin/belarra/normala/6.png");
		belar_normal_7 = new ImageIcon("/skin/belarra/normala/7.png");
		belar_normal_8 = new ImageIcon("/skin/belarra/normala/8.png");
		belar_normal_9 = new ImageIcon("/skin/belarra/normala/9.png");
	}
	
	public void mugimenduaKargatu(){
		belar_mugimendu_1 = new ImageIcon("/skin/belarra/mugimendua/1/1.gif");
		belar_mugimendu_2 = new ImageIcon("/skin/belarra/mugimendua/2/2.gif");
		belar_mugimendu_3 = new ImageIcon("/skin/belarra/mugimendua/3/3.gif");
		belar_mugimendu_4 = new ImageIcon("/skin/belarra/mugimendua/4/4.gif");
		belar_mugimendu_5 = new ImageIcon("/skin/belarra/mugimendua/5/5.gif");
		belar_mugimendu_6 = new ImageIcon("/skin/belarra/mugimendua/6/6.gif");
		belar_mugimendu_7 = new ImageIcon("/skin/belarra/mugimendua/7/7.gif");
		belar_mugimendu_8 = new ImageIcon("/skin/belarra/mugimendua/8/8.gif");
		belar_mugimendu_9 = new ImageIcon("/skin/belarra/mugimendua/9/9.gif");
	}
}
