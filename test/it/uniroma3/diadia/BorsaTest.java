package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

	Borsa borsaVuota;
	Borsa borsaSemiPiena;
	Borsa borsaPiena;
	
	//ATTREZZI
	private Attrezzo computer;
	private Attrezzo spada;
	private Attrezzo chiaveinglese; 
	private Attrezzo machete;
	private Attrezzo torcia;
	private Attrezzo coltello;
	private Attrezzo arco;
	private Attrezzo fucile;
	private Attrezzo corda;
	private Attrezzo proiettile;
	private Attrezzo freccia;
	private Attrezzo corona;
	
	@BeforeEach
	public void setUp() {
		
		borsaVuota = new Borsa();
		borsaSemiPiena = new Borsa();
		borsaPiena = new Borsa();
		
		computer = new Attrezzo("computer", 1);
		spada = new Attrezzo("spada", 1);
		chiaveinglese = new Attrezzo("chiaveinglese", 1);
		torcia = new Attrezzo("torcia", 1);
		coltello = new Attrezzo("coltello", 1);
		arco = new Attrezzo("arco", 1);
		fucile = new Attrezzo("fucile", 1);
		corda = new Attrezzo("corda", 1);
		machete = new Attrezzo("machete", 9);
		proiettile = new Attrezzo("proiettile", 1);
		freccia = new Attrezzo("freccia", 1);
		corona = new Attrezzo("corona", 1);
		
		borsaSemiPiena.addAttrezzo(computer);
		borsaSemiPiena.addAttrezzo(spada);
		borsaSemiPiena.addAttrezzo(chiaveinglese);
		borsaSemiPiena.addAttrezzo(torcia);
		borsaSemiPiena.addAttrezzo(coltello);
		
		borsaPiena.addAttrezzo(computer);
		borsaPiena.addAttrezzo(spada);
		borsaPiena.addAttrezzo(chiaveinglese);
		borsaPiena.addAttrezzo(torcia);
		borsaPiena.addAttrezzo(coltello);
		borsaPiena.addAttrezzo(arco);
		borsaPiena.addAttrezzo(fucile);
		borsaPiena.addAttrezzo(corda);
		borsaPiena.addAttrezzo(proiettile);
		borsaPiena.addAttrezzo(freccia);

	}
	
	@Test
	public void testAddAttrezzoBorsaVuota(){
		assertTrue(this.borsaVuota.addAttrezzo(arco));
	}
	
	@Test
	public void testAddAttrezzoBorsaSemiPiena(){
		assertTrue(this.borsaSemiPiena.addAttrezzo(arco));
	}
	
	@Test
	public void testAddAttrezzoBorsaPienaPerAttrezzi(){
		assertFalse(this.borsaPiena.addAttrezzo(corona));
	}
	
	@Test
	public void testAddAttrezzoBorsaPienaPerPeso(){
		assertFalse(this.borsaPiena.addAttrezzo(machete));
	}
	
	@Test
	public void testRemoveAttrezzoBorsaVuota(){
		assertEquals(null ,this.borsaPiena.removeAttrezzo("machete"));
	}
	
	@Test
	public void testRemoveAttrezzoBorsaSemiPiena(){
		assertEquals(computer ,this.borsaPiena.removeAttrezzo("computer"));
	}
	
	@Test
	public void testRemoveAttrezzoBorsaPiena(){
		assertEquals(coltello ,this.borsaPiena.removeAttrezzo("coltello"));
	}
	
	@Test
	public void testHasAttrezzoBorsaVuota(){
		assertFalse(this.borsaVuota.hasAttrezzo("arco"));
	}
	
	@Test
	public void testHasAttrezzoBorsaSemiPiena(){
		assertTrue(this.borsaSemiPiena.hasAttrezzo("computer"));
	}
	
	@Test
	public void testHasAttrezzoBorsaPienaConAttrezzoDentro(){
		assertTrue(this.borsaPiena.hasAttrezzo("computer"));
	}
	
	@Test
	public void testHasAttrezzoBorsaPienaSenzaAttrezzoDentro(){
		assertFalse(this.borsaPiena.hasAttrezzo("machete"));
	}
	
	@Test
	public void testGetPesoBorsaVuota(){
		assertEquals(0 ,this.borsaVuota.getPeso());
	}
	
	@Test
	public void testGetPesoBorsaSemiPiena(){
		assertEquals(5 ,this.borsaSemiPiena.getPeso());
	}
	
	@Test
	public void testGetPesoBorsaPiena(){
		assertEquals(10 ,this.borsaPiena.getPeso());
	}
}