package it.uniroma3.diadia.comand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comando.Comando;
import it.uniroma3.diadia.comando.ComandoVai;

public class ComandoVaiTest {

	private Stanza room1;
	private Stanza room2;
	private Comando vai;
	private Partita game;
	private IO io;
	private Labirinto lab;
	
	@BeforeEach
	public void setUp()  {
		room1 = new Stanza("room 1");
		room2 = new Stanza("room 2");
		vai = new ComandoVai();
		io = new IOConsole();
		lab = new Labirinto();
		game = new Partita(lab, io);
		
	}


	@Test
	public void testVaiNull() {
		game.getLabirinto().setStanzaCorrente(room1);
		vai.esegui(game);
		assertEquals(room1, game.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneEsistente() {
		game.getLabirinto().setStanzaCorrente(room1);
		room1.impostaStanzaAdiacente("sud-ovest", room2);
		vai.setParametro("sud-ovest");
		vai.esegui(game);
		assertEquals(room2, game.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneInesistente() {
		game.getLabirinto().setStanzaCorrente(room1);
		room1.impostaStanzaAdiacente("sud-ovest", room2);
		vai.setParametro("in fondo a destra");
		vai.esegui(game);
		assertNotEquals(room2, game.getLabirinto().getStanzaCorrente());
	}
	
}
