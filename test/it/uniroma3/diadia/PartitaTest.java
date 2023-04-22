package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	private Labirinto labirinto;
	private Giocatore giocatore;
	private Partita partita;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	boolean finita;
	int cfu;
	private IO io;

	@BeforeEach
	public void setUp() {
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore(io);
		this.partita = new Partita(io);
		this.finita = false;
		this.stanzaCorrente = new Stanza ("ingresso");
		this.stanzaVincente = new Stanza ("biblioteca");
		this.giocatore.setCfu(20);
	}
	
	@Test
	void testVinta1() {
		//all'inizio l'atrio non e' la stanza vincente...
		assertEquals(false, partita.vinta());
	}


	@Test
	void testIsFinita1() {
		//all'inizio della partita la partita non e' finita...
		assertEquals(false, partita.isFinita());
	}


	@Test
	void testGetLabirinto() {
		assertNotNull(partita.getLabirinto());
	}
	
	@Test
	void testGetGiocatore() {
		assertNotNull(partita.getGiocatore());
	}
	
    @Test
    void testSetFinita() {
    	assertEquals(true,partita.setFinita(finita));
    }
    
    @Test
	void testIsFinita2() {
    	partita.setFinita(finita);
		assertEquals(true, partita.isFinita());
	}
    
    
}