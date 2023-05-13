package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	
	private Labirinto labirinto;

	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
	}

	public LabirintoBuilder addStanzaIniziale(String nome) {
		Stanza iniziale = labirinto.getStanze().get(nome);
		if (iniziale != null)
			labirinto.setStanzaCorrente(iniziale);
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String nome) {
		Stanza vincente = labirinto.getStanze().get(nome);
		if (vincente != null)
			labirinto.setUscita(vincente);
		return this;
	}

	public LabirintoBuilder addStanza(String nome) {
		Stanza stanza = new Stanza(nome);
		labirinto.getStanze().put(nome, stanza);
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String nome,  String nomeAtt) {
		Stanza stanza = new StanzaBuia(nome, nomeAtt);
		labirinto.getStanze().put(nome, stanza);
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String nome, String chiave, String direzioneBloccata) {
		Stanza stanza = new StanzaBloccata(nome, chiave, direzioneBloccata );
		labirinto.getStanze().put(nome, stanza);
		return this;
	}

	public LabirintoBuilder addAttrezzo(String nomeStanza, String nomeAttrezzo, int peso) {
		Attrezzo ricercato = new Attrezzo(nomeAttrezzo, peso);
		Stanza ricercata = labirinto.getStanze().get(nomeStanza);
		if (ricercata != null) {
			ricercata.addAttrezzo(ricercato);
			labirinto.getAttrezzi().add(ricercato);
		}
		else
			ricercato = null;
		return this;
	}

	public LabirintoBuilder addAdiacenza(String nomePartenza, String nomeArrivo, String direzione) {
		Stanza partenza = labirinto.getStanze().get(nomePartenza);
		Stanza arrivo = labirinto.getStanze().get(nomeArrivo);
		if (partenza != null && arrivo != null) 
			partenza.impostaStanzaAdiacente(direzione, arrivo);
		return this;
	}

	public Labirinto getLabirinto() {
		return labirinto;
	}
}
