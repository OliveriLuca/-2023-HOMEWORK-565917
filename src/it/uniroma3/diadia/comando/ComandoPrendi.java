package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita) {
		 IO io = partita.getIO();

		/*mi serve la borsa del giocatore e la stanza dove posare l'attrezzo*/
		Borsa borsa = partita.getGiocatore().getBorsa();
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();

		/*rimuovo da stanza e posare in borsa*/
		if(this.nomeAttrezzo != null) {
			if(stanzaCorrente != null && borsa !=null) {
				Attrezzo a = stanzaCorrente.getAttrezzo(nomeAttrezzo);
				if(a != null ) {
					if (a.getPeso() + borsa.getPeso() < borsa.getPesoMax()) {
						stanzaCorrente.removeAttrezzo(a);
						borsa.addAttrezzo(a);
						io.mostraMessaggio(a.getNome()+ " messo in borsa, rimosso dalla stanza");
					}
					else {
						io.mostraMessaggio("la borsa pesa troppo!");
					}
				}
				else {
					io.mostraMessaggio("Attrezzo non presente nella stanza!"); 
				}
			}
		}	
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return "Attrezzo";
	}


}
