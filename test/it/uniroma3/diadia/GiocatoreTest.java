package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	private IO io;
	private Giocatore giocatore;
	private Giocatore giocatore0cfu;

	@BeforeEach
	public void setUp() {
		io = new IOConsole();
		this.giocatore = new Giocatore (io);
		this.giocatore0cfu = new Giocatore(io);
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