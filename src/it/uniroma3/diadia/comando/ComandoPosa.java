package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;


	@Override
	public void esegui(Partita partita) {
		IO io = partita.getIO();

		/*mi serve la borsa del giocatore e la stanza dove posare l'attrezzo*/
		Borsa borsa = partita.getGiocatore().getBorsa();
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();

		if(nomeAttrezzo != null) {
          if(borsa != null ) {
			/*rimuovo attrezzo dalla borsa*/
			Attrezzo a = borsa.removeAttrezzo(nomeAttrezzo);
			/*lo metto nella stanza*/
			stanzaCorrente.addAttrezzo(a); 
			io.mostraMessaggio("posato nella stanza, rimosso dalla borsa");
		}
		}
		
	}	

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}


	@Override
	public String getNome() {
		return "posa";		
	}


	@Override
	public String getParametro() {
		return this.nomeAttrezzo;	
	}
}
