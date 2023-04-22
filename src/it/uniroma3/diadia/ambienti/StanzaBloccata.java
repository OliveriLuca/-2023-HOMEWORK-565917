package it.uniroma3.diadia.ambienti;

/*una delle direzioni della
stanza non può essere seguita a meno che
nella stanza non sia presente un oggetto con un
nome particolare (ad esempio "passepartout")*/

public class StanzaBloccata extends Stanza {
	
 private String chiave;
 private String direzioneBloccata;
 
	public StanzaBloccata(String nome, String key, String direzioneBlocc) {
		super(nome);
		this.chiave = key;
		this.direzioneBloccata = direzioneBlocc;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(direzioneBloccata.equals(dir) && !this.hasAttrezzo(chiave)) {
			return this;
		}
		return super.getStanzaAdiacente(dir);
	}
	
	@Override
	public String getDescrizione() {
		StringBuilder bloccata = new StringBuilder(); 
		
		if(!this.hasAttrezzo(chiave))
			bloccata.append( "Stanza bloccata nella direzione: "+direzioneBloccata+"\nPrendi il "+chiave+" e posalo nella stanzaBloccata");;
		
		return bloccata.append(super.getDescrizione()).toString();	
	}

}
