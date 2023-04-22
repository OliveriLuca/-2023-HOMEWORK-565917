package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		IO io = partita.getIO();
		
		//STAMPARE:
		//numero CFU giocatore,
		io.mostraMessaggio("Hai "+ partita.getGiocatore().getCfu()+ " cfu");
		//gli attrezzi nella borsa	 
        io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
      //gli attrezzi nella stanza, il nome della stanza, le direzioni possibili
        io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione()); 
		
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getNome() {
		return "guarda";
	}

	@Override
	public String getParametro() {
		return null;
	}

}
