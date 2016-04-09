package org.pokesweeper.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.pokesweeper.model.Tableroa;


public class Ranking {
	
	File fitxRanking;
	private static Ranking nireRanking;
	
	private Ranking(){
		fitxRanking=new File("ranking.txt");
		if (!fitxRanking.exists()){
			try {
				fitxRanking.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		if (minakop == 7){
			maila=1;
		}
		else{
			if (minakop==20){
				maila=2;
			}
			else{
				maila=3;
			}
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
						 //actualizar
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

}
