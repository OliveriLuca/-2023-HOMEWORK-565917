package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	public IO io;
	private Stanza stanzaVincente;

	public Partita(Labirinto labirinto, IO io){
		this.finita = false;
		this.labirinto = labirinto;
		this.giocatore = new Giocatore(io);
		this.io = io;
		this.stanzaVincente = this.labirinto.getUscita();
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente() == this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {

		if (vinta()) {
			io.mostraMessaggio("Hai raggiunto la stanza vincente ! ");
			return true;		
		}
		else 
			if (this.giocatore.getCfu() == 0) {
				io.mostraMessaggio("Hai esaurito i crediti. Mi spiace, hai preso !");
				return true;
			}
			else
				if (finita) {
				return true;
				}
			else
				return false;
	}


	/* Imposta la partita come finita */
	public boolean setFinita(boolean finita) {
		finita = true;
		return this.finita = finita;
	}

	public Labirinto  getLabirinto(){
		return this.labirinto;
	}

	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}

	public IO getIO() {
		return this.io;
	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
}