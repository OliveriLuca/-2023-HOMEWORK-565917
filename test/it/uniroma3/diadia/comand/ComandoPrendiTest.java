package it.uniroma3.diadia.comand;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comando.ComandoPrendi;

class ComandoPrendiTest {

	private ComandoPrendi comandoPrendi;
	private Partita partita;
	private IO io;
	private Attrezzo attrezzo;
	private Labirinto lab;

	@BeforeEach
	void setUp(){
		this.lab = new Labirinto();
		this.comandoPrendi = new ComandoPrendi();
		this.io = new IOConsole();
		this.partita = new Partita(lab, io);
		this.attrezzo = new Attrezzo("machete", 3);
		
		lab.setStanzaCorrente(new Stanza("prova"));
		this.lab.getStanzaCorrente().addAttrezzo(this.attrezzo);
			
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
