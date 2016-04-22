package org.pokesweeper.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pokesweeper.model.DenboraKontadorea;
import org.pokesweeper.view.JokoaUI;

public class DenboraKontadoreaTest {
	
	DenboraKontadorea kontadorea;
	JokoaUI nireJokoaUI;
	
	@Before
	public void setUp() throws Exception {
		nireJokoaUI = JokoaUI.getNireJokoa();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testDenboraKontadorea() {
		kontadorea = new DenboraKontadorea();
		assertTrue(kontadorea.getKont() == 0);
		try {
		    Thread.sleep(4000);          
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		assertTrue(kontadorea.getKont() == 3);
		
		kontadorea.denboraGelditu();
		try {
		    Thread.sleep(4000);          
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		assertTrue(kontadorea.getKont() == 3);
		
		kontadorea.denboraErreseteatu();
		assertTrue(kontadorea.getKont() == 0);
		try {
		    Thread.sleep(4000);          
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		assertTrue(kontadorea.getKont() == 3);
	}
}
