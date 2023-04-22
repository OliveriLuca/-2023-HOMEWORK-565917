package it.uniroma3.diadia.comand;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comando.ComandoPrendi;

class ComandoPrendiTest {

	private ComandoPrendi comandoPrendi;
	private Partita partita;
	private IO io;
	private Attrezzo attrezzo;
	

	@BeforeEach
	void setUp(){
		
		this.comandoPrendi = new ComandoPrendi();
		this.io = new IOConsole();
		this.partita = new Partita(io);
		this.attrezzo = new Attrezzo("machete", 3);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
			
	}

	@Test
	void testEseguiComandoPrendi() {
		
			this.comandoPrendi.setParametro("machete");
			this.comandoPrendi.esegui(this.partita);		
			assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("machete"));
			assertFalse(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo("machete"));
	}

	@Test
	void testEseguiComandoPrendiSbagliato() {
		
			this.comandoPrendi.setParametro("Spada");
			this.comandoPrendi.esegui(this.partita);
			assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Spada"));
	}

	
}
