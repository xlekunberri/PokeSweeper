package org.pokesweeper.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pokesweeper.model.MinaKontadorea;
import org.pokesweeper.view.JokoaUI;

public class MinaKontadoreaTest {
	
	MinaKontadorea kontadorea;
	JokoaUI nireJokoaUI;

	@Before
	public void setUp() throws Exception {
		kontadorea = new MinaKontadorea();
		nireJokoaUI = JokoaUI.getNireJokoa();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinaKontadorea() {
		/*
		 * Kontadorearen metodoak probatu ditugu, kontadoreaEguneratu izan ezik (grafikoki testeatu daiteke)
		 */
		kontadorea.minaKopuruaJarri(2);
		assertTrue(kontadorea.getKont() == 2);
		
		kontadorea.minaKendu();
		assertTrue(kontadorea.getKont() == 1);
		kontadorea.minaKendu();
		assertTrue(kontadorea.getKont() == 0);
		
		kontadorea.minaGehitu();
		assertTrue(kontadorea.getKont() == 1);
		kontadorea.minaGehitu();
		assertTrue(kontadorea.getKont() == 2);
		
		kontadorea.kontadoreaErreseteatu();
		assertTrue(kontadorea.getKont() == 0);
		
	}

}
