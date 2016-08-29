package hr.vvg.java.vjezbe.entitet;

public class Knjiga {
	
	private String nazivKnjige;
	private String jezikKnjige;
	private Izdavac izdavacKnjige;

	public Knjiga(String nazivKnjige, String jezikKnjige, Izdavac izdavacKnjige) {
		this.nazivKnjige = nazivKnjige;
		this.jezikKnjige = jezikKnjige;
		this.izdavacKnjige = izdavacKnjige;
	}

	public String getNazivKnjige() {
		return nazivKnjige;
	}

	public String getJezikKnjige() {
		return jezikKnjige;
	}

	public Izdavac getIzdavacKnjige() {
		return izdavacKnjige;
	}	
}
