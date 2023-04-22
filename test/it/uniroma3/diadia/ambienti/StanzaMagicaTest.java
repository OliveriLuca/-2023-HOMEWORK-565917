package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	private Attrezzo spada;
	private Attrezzo lancia;
	private Attrezzo pizza;
	private Attrezzo mela;

	private Stanza atrio;
	private StanzaMagica magica;

	@BeforeEach
	void setUp() {
		this.spada = new Attrezzo("spada", 2);
		this.lancia = new Attrezzo ("lancia", 4);
		this.pizza = new Attrezzo ("pizza", 1);
		this.mela = new Attrezzo ("mela", 1);
		this.atrio = new Stanza("Atrio");
		this.magica = new StanzaMagica("magica");
	}

	@Test
	void testAddAttrezzoNonMagico() {
		atrio.addAttrezzo(lancia);
		assertEquals(this.lancia, atrio.getAttrezzo("lancia"));
	}
	
	@Test
	void testAddAttrezzoNonMagico2() {
		magica.addAttrezzo(lancia);
		assertEquals(this.lancia, magica.getAttrezzo("lancia"));
	}

	@Test
	void testAddAttrezzoMagico() {
		magica.addAttrezzo(lancia);
		magica.addAttrezzo(mela);

		magica.addAttrezzo(pizza); //Questa aggiunta dovrebbe scatenare il comportamento magico
		magica.addAttrezzo(spada); //Questa aggiunta dovrebbe scatenare il comportamento magico

		assertNotNull(magica.getAttrezzo("lancia")); //nome non invertito
		assertNotNull(magica.getAttrezzo("mela"));   //nome non invertito

		assertNotNull(magica.getAttrezzo("azzip"));  //nome invertito per effetto magico
		assertNotNull(magica.getAttrezzo("adaps"));  //nome invertito per effetto magico

		assertNull(magica.getAttrezzo("pizza"));     //non ci sono piu coi nomi normali
		assertNull(magica.getAttrezzo("spada"));
	}
	
	@Test
	void testModificaAttrezzo() {
		magica.addAttrezzo(lancia);
		magica.addAttrezzo(pizza);
		
		/*si attiva il comportamento magico*/
		magica.addAttrezzo(mela);
		/*mela modificata quindi da modificata attrezzo*/
		/*inverte il nome e raddoppia ilpeso*/
		assertNotNull(magica.getAttrezzo("alem"));  
		assertEquals(2,magica.getAttrezzo("alem").getPeso());
		/*verificata quindi pure modifica attrezzo, viene raddoppiato il peso */
	}

}
