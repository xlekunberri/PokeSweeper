package org.pokesweeper.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pokesweeper.model.MinaKontadorea;

public class MinaKontadoreaTest {
	
	MinaKontadorea kontadorea;

	@Before
	public void setUp() throws Exception {
		kontadorea = new MinaKontadorea();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinaKendu() {
		kontadorea.minaKopuruaJarri(1);
		kontadorea.minaKendu();
		assertTrue(kontadorea.getKont() == 0);
	}

}
