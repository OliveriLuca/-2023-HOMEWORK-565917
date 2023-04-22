package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza{
    
	//StanzaMagica labIA = ...
	//String s = labIA.getDescrizione();
	
	final static public int SOGLIA_MAGICA_DEFAULT = 2; //valore di default per la soglia

	private int contatoreAttrezziPosati; //memorizza il numero di attrezzi posati

	private int sogliaMagica; //memorizza il numero di attrezzi da posare prima 
	//che si attivi il comportamento «magico» della stanza


	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}

	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	//private Attrezzo modificaAttrezzo(Attrezzo attrezzo) che
	//restituisce un attrezzo a partire dall'attrezzo passato come
	//parametro
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		return attrezzo;
	}

	//	ridefinisce il metodo addAttrezzo(Attrezzo attrezzo) per
	//	implementare l'effetto magico
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		
		if (this.contatoreAttrezziPosati > this.sogliaMagica) 
		attrezzo = this.modificaAttrezzo(attrezzo);
		
		return super.addAttrezzo(attrezzo);
	}
	
}
