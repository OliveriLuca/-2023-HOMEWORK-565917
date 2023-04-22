package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{
	
	final static private int SOGLIA_MAGICA_DEFAULT = 3; //valore di default per la soglia

	private int contatoreAttrezziPosati; //memorizza il numero di attrezzi posati

	private int sogliaMagica; //memorizza il numero di attrezzi da posare prima 
	//che si attivi il comportamento «magico» della stanza

		public StanzaMagicaProtected(String nome, int soglia) {
			super(nome);
			this.contatoreAttrezziPosati = 0;
			this.sogliaMagica = soglia;
		}

		public StanzaMagicaProtected(String nome) {
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

			if (this.numeroAttrezzi < this.attrezzi.length) {
				this.attrezzi[this.numeroAttrezzi] = attrezzo;
				this.numeroAttrezzi++;
				return true;
			}
			else 
				return false;
		}


	}
