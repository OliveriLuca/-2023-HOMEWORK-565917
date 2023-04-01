package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	private Giocatore giocatore = new Giocatore();
	private Giocatore giocatore0cfu = new Giocatore();

	@BeforeEach
	public void setUp() {
		this.giocatore.setCfu(20);
		this.giocatore0cfu.setCfu(0);
	}

	@Test
	void testGetCfu() {
		assertEquals(20, this.giocatore.getCfu());
	}

	@Test
	void testGet0Cfu() {
		assertEquals(0, this.giocatore0cfu.getCfu());
	}
}