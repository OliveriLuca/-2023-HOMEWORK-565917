package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;

	@Override
	public void esegui(Partita partita) {
		IO io = partita.getIO();
		Stanza corrente = partita.getLabirinto().getStanzaCorrente();

		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare ?"); 
			return;
		} else {
			Stanza prossima = null;
			prossima = corrente.getStanzaAdiacente(direzione);
			
			if (prossima == null) {
				io.mostraMessaggio("Direzione inesistente");
			}

			else {
			    partita.getLabirinto().setStanzaCorrente(prossima);
				int cfu = partita.getGiocatore().getCfu();
				partita.getGiocatore().setCfu(--cfu);
				io.mostraMessaggio("Ora hai " + partita.getGiocatore().getCfu() + " cfu");
				io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
			}
			
		}
		

	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
		
	}

	@Override
	public String getNome() {
		return "vai";
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}
	
	
	
}
