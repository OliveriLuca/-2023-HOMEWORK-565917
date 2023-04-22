package it.uniroma3.diadia.ambienti;

/*se nella stanza non è
presente un attrezzo con un nome particolare
(ad esempio "lanterna") il metodo
getDescrizione() di una stanza buia ritorna la
stringa "qui c'è un buio pesto"*/

public class StanzaBuia extends Stanza {
	
	private String attrezzoLuminoso;
 
	public StanzaBuia(String nome, String nomeAtt) {
		super(nome);
		this.attrezzoLuminoso = nomeAtt;
	}

	@Override
	public String getDescrizione() {
	   String buio = new String();
	   buio = "Qui c'è buio pesto!";
	   if(!this.hasAttrezzo(attrezzoLuminoso)) {
		   return buio;
	   }
	   else{
		   return super.getDescrizione();
	   }
	}
	
	

}
