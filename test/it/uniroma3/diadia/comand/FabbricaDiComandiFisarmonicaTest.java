package it.uniroma3.diadia.comand;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comando.ComandoAiuto;
import it.uniroma3.diadia.comando.ComandoFine;
import it.uniroma3.diadia.comando.ComandoGuarda;
import it.uniroma3.diadia.comando.ComandoNonValido;
import it.uniroma3.diadia.comando.ComandoPosa;
import it.uniroma3.diadia.comando.ComandoPrendi;
import it.uniroma3.diadia.comando.ComandoVai;

class FabbricaDiComandiFisarmonicaTest {

	ComandoAiuto comandoAiuto;
	ComandoFine comandoFine;
	ComandoGuarda comandoGuarda;
	ComandoNonValido comandoNonValido;
	ComandoPosa comandoPosa;
	ComandoPrendi comandoPrendi;
	ComandoVai comandoVai;


	@BeforeEach
	void setUp() {

		comandoAiuto = new ComandoAiuto();
		comandoFine = new ComandoFine();
		comandoGuarda = new ComandoGuarda();
		comandoNonValido = new ComandoNonValido();
		comandoPosa = new ComandoPosa();
		comandoPrendi = new ComandoPrendi();
		comandoVai = new ComandoVai();

	}

	@Test

	public void testCostruisciComandoAiuto() {

		assertEquals("aiuto",comandoAiuto.getNome());

	}

	@Test

	void testCostruisciComandoAiutoSbagliato() {
		
		assertNotEquals("ComandoAiu",comandoAiuto.getNome());

	}

	@Test

	void testCostruisciComandoFine() {

		assertEquals("fine",comandoFine.getNome());

	}

	@Test

	void testCostruisciComandoFineSbagliato() {

		assertNotEquals("ComandoFina",comandoFine.getNome());

	}

	@Test

	void testCostruisciComandoGuarda() {

		assertEquals("guarda",comandoGuarda.getNome());

	}

	@Test

	void testCostruisciComandoGuardaSbagliato() {

		assertNotEquals("ComandoGuards",comandoGuarda.getNome());

	}

	@Test

	void testCostruisciComandoNonValido() {

		assertEquals("ComandoNonValido",comandoNonValido.getNome());

	}

	@Test

	void testCostruisciComandoNonValidoSbagliato() {

		assertNotEquals("ComandoNonValidi",comandoNonValido.getNome());

	}

	@Test

	void testCostruisciComandoPosa() {

		assertEquals("posa",comandoPosa.getNome());
		comandoPosa.setParametro("Attrezzo");
		assertEquals("Attrezzo", comandoPosa.getParametro());

	}

	@Test

	void testCostruisciComandoPosaSbagliato() {

		assertNotEquals("ComandoPosi",comandoPosa.getNome());
		comandoPosa.setParametro("Attrezzo");
		assertNotEquals("Attrezzi", comandoPosa.getParametro());

	}

	@Test

	void testCostruisciComandoPrendi() {

		assertEquals("prendi",comandoPrendi.getNome());
		comandoPrendi.setParametro("Attrezzo");
		assertEquals("Attrezzo", comandoPrendi.getParametro());

	}

	@Test

	void testCostruisciComandoPrendiSbagliato() {

		assertNotEquals("ComandoPrendo",comandoPrendi.getNome());
		comandoPrendi.setParametro("Attrezzo");
		assertNotEquals("Attrezzi", comandoPrendi.getParametro());

	}

	@Test

	void testCostruisciComandoVai() {

		assertEquals("vai",comandoVai.getNome());
		comandoVai.setParametro("sud");
		assertEquals("sud", comandoVai.getParametro());

	}

	@Test

	void testCostruisciComandoVaiSbagliato() {

		assertNotEquals("ComandoVa",comandoVai.getNome());
		comandoVai.setParametro("sud");
		assertNotEquals("sudd", comandoVai.getParametro());

	}

}


