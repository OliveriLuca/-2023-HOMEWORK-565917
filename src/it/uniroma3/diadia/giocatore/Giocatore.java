package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.IO;

/* ha la responsabilita di gestire cfu giocatore e
 * memorizzare gli attrezzi in un oggetto istanza della classe Borsa. */

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	public IO io;

	public Giocatore(IO io){
		this.cfu = CFU_INIZIALI;
		this.io = io;
		this.borsa = new Borsa(io);
	}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	

	public Borsa getBorsa() {
		return borsa;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}

}