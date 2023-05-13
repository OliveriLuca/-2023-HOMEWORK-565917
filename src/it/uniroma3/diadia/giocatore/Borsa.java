package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;
	private IO io;

	public Borsa(IO io) {
		this(DEFAULT_PESO_MAX_BORSA, io);
	}

	public Borsa(int pesoMax, IO io) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>(); 
		this.io = io;

	}


	public int getPesoMax() {
		return pesoMax;
	}

	/*cerca l'attrezzo nella borsa*/
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		if(this.attrezzi.containsKey(nomeAttrezzo)) {
			return this.attrezzi.get(nomeAttrezzo);
		}
		else
			return null;	
	}

	public int getPeso() {
		int peso = 0;
		for (Attrezzo a: this.attrezzi.values()) {
			peso += a.getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo != null) {
			if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
				return false;
			if (this.attrezzi.size() == 10)
				return false;
			this.attrezzi.put(attrezzo.getNome(), attrezzo);	
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
				this.attrezzi.remove(a.getNome());
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
			s.append(this.attrezzi.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}


	/*restituisce la lista degli attrezzi nella borsa ordinati per peso e
	quindi, a parità di peso, per nome*/
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> l = new ArrayList<Attrezzo>();
		// devi estrarre lista attrezzi da mappa
		l.addAll(this.attrezzi.values());
		Collections.sort(l, new ComparatorePerPeso());

		return l;

	}


	/*restituisce l'insieme degli attrezzi nella borsa ordinati per nome*/
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		ComparatorePerNome cmpNome = new ComparatorePerNome();
		SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(cmpNome);
		s.addAll(this.attrezzi.values());
		return s;
	}


	/*restituisce una mappa che associa un intero (rappresentante un
	peso) con l’insieme (comunque non vuoto) degli attrezzi di tale
	peso: tutti gli attrezzi dell'insieme che figura come valore hanno
	lo stesso peso pari all'intero che figura come chiave*/
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> newMappa = new HashMap<Integer,Set<Attrezzo>>();

		for(Attrezzo a: this.attrezzi.values()) {
			if(newMappa.containsKey(a.getPeso())) {
				newMappa.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo> setAtt = new HashSet<Attrezzo>();
				setAtt.add(a);
				newMappa.put(a.getPeso(), setAtt);
			}
		}
		return newMappa;
	}
	
	
	/* restituisce gli attrezzi nella borsa
	ordinati per peso e quindi, a parità di peso, per nome*/
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatorePerPeso cmpPeso = new ComparatorePerPeso();
		SortedSet<Attrezzo> s1 = new TreeSet<Attrezzo>(cmpPeso);
		s1.addAll(this.attrezzi.values());
		return s1;
	}


}
