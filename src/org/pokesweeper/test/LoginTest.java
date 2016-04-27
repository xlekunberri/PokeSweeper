package org.pokesweeper.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pokesweeper.model.Login;

public class LoginTest {
	
	Login login;

	@Before
	public void setUp() throws Exception {
		login = Login.getNireLogin();
		login.jUniteraAldatu();
	}

	@After
	public void tearDown() throws Exception {
		login.jUnitEzabatu();
		login = null;
	}

	@Test
	public void testErabiltzaileaSortu() {
		assertTrue(login.erabiltzaileaSortu("test", "test"));
		assertFalse(login.erabiltzaileaSortu("test", "test"));
		assertFalse(login.erabiltzaileaSortu("test", "test2"));
		assertTrue(login.erabiltzaileaSortu("test2", "test"));
	}

}
