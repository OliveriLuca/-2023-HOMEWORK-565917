package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	private StanzaBuia stanza;
	private Attrezzo candela;
	
	@BeforeEach 
	public void setUp() {
		stanza = new StanzaBuia("StanzaBuia", "candela");
		candela = new Attrezzo("candela", 1);
	}

	@Test
	public void testGetDescrizioneConAttrezzo() {
		stanza.addAttrezzo(candela);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		String e = "Qui c'è buio pesto!";
		assertEquals(e, stanza.getDescrizione());
	}

}
