package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/* ha la responsabilita di creare il labirinto,
 * di memorizzare la stanza iniziale(di entrata)
 * e quella finale(uscita)*/

public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza uscita;
	private Map<String, Stanza> stanze;
	private List<Attrezzo> attrezzi;

	public Labirinto() {
		
		this.stanze = new HashMap<String, Stanza>();
		this.attrezzi = new ArrayList<Attrezzo>();
		
	}

	public Stanza getUscita() {
		return uscita;
	}
	
	public Stanza setUscita(Stanza usc) {
		return this.uscita = usc;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Map<String, Stanza> getStanze() {
		return stanze;
	}

	public void setStanze(Map<String, Stanza> stanze) {
		this.stanze = stanze;
	}


	public List<Attrezzo> getAttrezzi() {
		return attrezzi;
	}


	public void setAttrezzi(List<Attrezzo> attrezzi) {
		this.attrezzi = attrezzi;
	}

}
