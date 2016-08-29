package hr.vvg.java.vjezbe.entitet;

import java.time.LocalDateTime;

public class Posudba {
	
	private Clan nekiClan;
	
	private Knjiga nekaKnjiga;
	
	private LocalDateTime datumPosudbe;

	public Posudba(Clan nekiClan, Knjiga nekaKnjiga, LocalDateTime datumPosudbe) {
		this.nekiClan = nekiClan;
		this.nekaKnjiga = nekaKnjiga;
		this.datumPosudbe = datumPosudbe;
	}

	public Clan getNekiClan() {
		return nekiClan;
	}

	public Knjiga getNekaKnjiga() {
		return nekaKnjiga;
	}

	public LocalDateTime getDatumPosudbe() {
		return datumPosudbe;
	}
}
