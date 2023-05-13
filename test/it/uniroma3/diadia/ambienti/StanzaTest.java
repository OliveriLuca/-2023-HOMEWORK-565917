package it.uniroma3.diadia.ambienti; //passi il pacchetto della classe dove fai il test
import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaTest {
	private static final int MAX_ATTREZZI = 10;
	private Stanza stanzaTest;
	private Attrezzo scudo;
	private Attrezzo spada;
	private Attrezzo osso;

	@BeforeEach
	public void setUp() {
		this.stanzaTest = new Stanza("stanzaTest");
		this.scudo = new Attrezzo("scudo", 2);
		this.spada = new Attrezzo("spada", 3);
		this.osso = new Attrezzo("osso", 8);
	}

	
	@Test
     void testAddAttrezzo() {
		assertEquals(true, stanzaTest.addAttrezzo(scudo));	
		assertEquals(true, stanzaTest.removeAttrezzo(scudo));

	}

//	@Test 
//	void testRemoveAttrezzo(){
//		assertEquals(true, stanzaTest.removeAttrezzo(scudo));
//	}

	@Test 
	void testHasAttrezzo(){
		assertEquals (false, stanzaTest.hasAttrezzo("scudo"));
	}
    
	@Test
	void testGetAttrezzo() {
		assertNull(stanzaTest.getAttrezzo("scudo"));
	}
	
	@Test
	void testAddAttrezzo2() {
		assertEquals(true, stanzaTest.addAttrezzo(spada));	
	}
	
	@Test
	void testAddAttrezzo3() {
		assertEquals(true, stanzaTest.addAttrezzo(osso));	
	}
	
	@Test 
	public void testGetAttrezzoEsistente() {
		Attrezzo esistente = new Attrezzo("lanterna",1);
		stanzaTest.addAttrezzo(esistente);
		assertEquals(esistente,stanzaTest.getAttrezzo("lanterna"));
	}

	@Test
	public void testGetAttrezzoNonEsistente() {
		assertNull(stanzaTest.getAttrezzo("lanterna"));
	}

}
