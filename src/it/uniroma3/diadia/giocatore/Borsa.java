package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private IO io;

	public Borsa(IO io) {
		this(DEFAULT_PESO_MAX_BORSA, io);
	}

	public Borsa(int pesoMax, IO io) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
		this.io = io;

	}

	public int getNumeroAttrezzi() {
		return numeroAttrezzi;
	}

	public void setNumeroAttrezzi(int numeroAttrezzi) {
		this.numeroAttrezzi = numeroAttrezzi;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	/*cerca l'attrezzo nella borsa*/
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;

		for (int i= 0; i<attrezzi.length; i++) {
			if (this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = attrezzi[i];
				return a;
			}
		}
		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.attrezzi.length; i++) {
			if(this.attrezzi[i] != null){
				peso += this.attrezzi[i].getPeso();
			} 
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo != null) {
			if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
				return false;
			if (this.numeroAttrezzi == 10)
				return false;
			this.attrezzi[this.numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		return false;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {

		Attrezzo a = null;
		if(isEmpty()) {
			io.mostraMessaggio("borsa vuota, non puoi rimuovere nessun attrezzo!");
			return a;
		}
		else {
			a = getAttrezzo(nomeAttrezzo);
			if(a != null) {
				int i=0;
				while(attrezzi[i] == null || !attrezzi[i].getNome().equals(a.getNome()) ) {
					i++;
				}
				this.attrezzi[i] = null;
				--this.numeroAttrezzi;
				return a;
			}
			else {
				io.mostraMessaggio("Attrezzo non presente nella borsa!");
			}
		}
		return a;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.attrezzi.length; i++) {
				if(this.attrezzi[i] != null) {
				s.append(this.attrezzi[i].toString()+" ");
				}
			}
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

}
