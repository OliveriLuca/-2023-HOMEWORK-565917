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
	boolean finita;
	int cfu;
	private IO io;

	@BeforeEach
	public void setUp() {
		this.io = new IOConsole();
		this.labirinto = new Labirinto();
		this.labirinto.setStanzaCorrente(new Stanza ("ingresso"));
		this.labirinto.setUscita(new Stanza ("biblioteca"));
		this.giocatore = new Giocatore(io);
		this.partita = new Partita(labirinto, io);
		this.finita = false;
		this.giocatore.setCfu(20);
	}
	
	@Test
	void testVinta1() {
		
		assertEquals(false, partita.vinta());
	}


	@Test
	void testIsFinita1() {
		
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

	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
    
    
}