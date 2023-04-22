package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.Partita;

public interface FabbricaDiComandi {
  public Comando costruisciComando(String nomeComando);
  public void setPartita(Partita partita);
}
