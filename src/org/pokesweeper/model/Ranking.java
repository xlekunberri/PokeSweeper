package org.pokesweeper.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ranking {
	
	File fitxRanking;
	private static Ranking nireRanking;
	
	private Ranking(){
		fitxRanking=new File("ranking.txt");
		if (!fitxRanking.exists()){
			try {
				fitxRanking.createNewFile();
			} catch (IOException e) {e.printStackTrace();}
		}
	}
	
	public static Ranking getNireRanking(){ 
		 
	    	if (nireRanking == null) {
				nireRanking = new Ranking();
			}
			return nireRanking;
	    }
	
	public void idatzi(String pIzena, int pDenbora) throws IOException{
		fitxRanking=new File("ranking.txt");
		int maila;
		int minakop = Tableroa.getNireTableroa().getMinaKop();
		switch (minakop) {
		case 7:
			maila = 1;
			break;
		case 20:
			maila = 2;
			break;
		default:
			maila = 3;
			break;
		}
		try{
			if (!baDago(pIzena,pDenbora,maila)){
				FileWriter fw=new FileWriter(fitxRanking, true);
				BufferedWriter output=new BufferedWriter(fw);
				output.write(pIzena + " ### " + Integer.toString(pDenbora) + " ### " + maila);
				output.newLine();
				output.close();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	private boolean baDago(String pIzena, int pDenbora, int pMaila) { //if true actualiza
		fitxRanking=new File("ranking.txt");
		boolean dago=false;
		try{
			 Scanner sarrera = new Scanner(new FileReader(fitxRanking));
			 String lerroa;
			 while (sarrera.hasNext() && !dago) {
				 lerroa = sarrera.nextLine();
				 String[] hitzak=lerroa.split(" ### ");
				 if (hitzak[0].equals(pIzena) && Integer.parseInt(hitzak[2])==pMaila){
					 dago = true;
					 if (pDenbora < Integer.parseInt(hitzak[1])){ //si se cumple, actualizar
						 
						 Path path = Paths.get("ranking.txt");
						 Charset charset = StandardCharsets.UTF_8;

						 String content = new String(Files.readAllBytes(path), charset);
						 content = content.replaceAll(lerroa ,hitzak[0] + " ### " + Integer.toString(pDenbora) + " ### " + hitzak[2]);
						 Files.write(path, content.getBytes(charset));

					 }
				 }
			 }
			 sarrera.close();
			 }
		catch(IOException e){
			 e.printStackTrace();
		}
		return dago;
	}
	
	public String[] rankingLortu(int pMaila){
		fitxRanking=new File("ranking.txt");
		String[] hoberenak = new String[10];
		String[] izenak = new String[10];
		int min=1000;
		String izena=null;
		int i=0;
		boolean bukatua = false;
		try{
			while (i<10 && !bukatua){
				 Scanner sarrera = new Scanner(new FileReader(fitxRanking));
				 String lerroa;
				 min=1000;
				 izena=null;
				 while (sarrera.hasNext()) {
					 lerroa = sarrera.nextLine();
					 String[] hitzak=lerroa.split(" ### ");
					 if (Integer.parseInt(hitzak[2])==pMaila){
						 if ((Integer.parseInt(hitzak[1])<min) && !barruanDago(izenak,hitzak[0]) ){
							 min = Integer.parseInt(hitzak[1]);
							 izena = hitzak[0];
						 }
					 }
				 }
				 if (izena != null ){
					 hoberenak[i] = izena + " " + min + "s";
					 izenak[i] = izena;
					 i++;
					 sarrera.close();
				 }
				 else {
					 bukatua=true;
				 }
			}
		}
			 
		catch(IOException e){
			 e.printStackTrace();
		}
		return hoberenak;
		
	}

	private boolean barruanDago(String[] izenak, String iz) {
		int i=0;
		boolean dago=false;
		while (i<10 && izenak[i] != null){
			if (izenak[i].equals(iz)){
				dago=true;
			}
			i++;
		}
		return dago;
	}

}
