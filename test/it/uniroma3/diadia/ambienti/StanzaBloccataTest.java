package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

	private StanzaBloccata lockedRoom;
	private Stanza room ;
	private Attrezzo att;
	
	@BeforeEach
	public void setUp() {
		lockedRoom = new StanzaBloccata("StanzaBloccata", "piedediporco","ovest");
		room = new Stanza("Room");
		att = new Attrezzo("piedediporco", 1);
		lockedRoom.impostaStanzaAdiacente("ovest", room);
		
	}

	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(lockedRoom, lockedRoom.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		lockedRoom.addAttrezzo(att);
		assertEquals(room, lockedRoom.getStanzaAdiacente("ovest"));
		
	}

	@Test
	public void testGetDescrizioneDirezioneSbloccata() {
		lockedRoom.addAttrezzo(att);
		assertEquals(lockedRoom.toString(), lockedRoom.getDescrizione());
	}
	
}
