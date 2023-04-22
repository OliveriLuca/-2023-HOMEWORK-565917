package it.uniroma3.diadia;

public class IOSimulator implements IO {

	private String[] righeLette;
	private int indiceRigheLette;
	private String[] messaggiProdotti;
	private int indiceMessProd;
	private int indiceMessMostrati;
	
	public IOSimulator(String[] righeDaLeggere) {
		this.righeLette = righeDaLeggere;
		this.indiceRigheLette = 0;
		this.indiceMessMostrati = 0;
		this.messaggiProdotti = new String[42*23];
	}

	
	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiProdotti[indiceMessProd] = msg;
		this.indiceMessProd++;
	}

	@Override
	public String leggiRiga() {
		String riga = null;

		riga = this.righeLette[indiceRigheLette];
		this.indiceRigheLette++;
		return riga;
	}
	
	public String nextMessaggio() {
		String next = this.messaggiProdotti[this.indiceMessMostrati];
		this.indiceMessMostrati++;
		return next;
	}

	public boolean hasNextMessaggio() {
		return this.indiceMessMostrati < this.indiceMessProd;
	}

	
	public String[] getMessaggiProdotti() {
		return messaggiProdotti;
	}

	public void setMessaggiProdotti(String[] messaggiProdotti) {
		this.messaggiProdotti = messaggiProdotti;
	}
	
	

}
