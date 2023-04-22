package it.uniroma3.diadia;

import it.uniroma3.diadia.comando.FabbricaDiComandi;
import it.uniroma3.diadia.comando.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	public static final String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";


	public Partita partita;
	private static IO io;
	public FabbricaDiComandi processa;

	public DiaDia(IO IOConsole) {
		this.io = IOConsole;
		this.partita = new Partita(IOConsole);
		this.processa = new FabbricaDiComandiFisarmonica();
		this.processa.setPartita(this.partita);
	}

	public void gioca() {
		String istruzione; 		
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);    
				
		do		
			istruzione = io.leggiRiga();
		while (processa.costruisciComando(istruzione) != null && !partita.isFinita());
	}   
	
	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}
	