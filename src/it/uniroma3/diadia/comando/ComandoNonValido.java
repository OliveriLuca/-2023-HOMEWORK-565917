package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
 
	@Override
	public void esegui(Partita partita) {
		IO io = partita.getIO();
		io.mostraMessaggio("Comando inesistente! ");
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getNome() {
		return "ComandoNonValido";
	}

	@Override
	public String getParametro() {
		return null;
	}

}
