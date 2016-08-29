package hr.vvg.java.vjezbe.glavna;

import hr.vvg.java.vjezbe.entitet.Clan;
import hr.vvg.java.vjezbe.entitet.Izdavac;
import hr.vvg.java.vjezbe.entitet.Knjiga;
import hr.vvg.java.vjezbe.entitet.Posudba;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Glavna {
	
	
	public static void main(String[] args) {
		
		 Scanner ulazni = new Scanner(System.in);
		
		 Knjiga knjiga[] = new Knjiga[2];
		
		 Clan clan;
		
		 Posudba posudba;
		
		for (int i = 0; i < 2; i++){
			
			knjiga[i] = unesiKnjigu(i, ulazni);
		
		}
		
		
		clan = unosClana(ulazni);
		
		posudba = odaberiKnjigu(knjiga, clan, ulazni);
		
		stanjePosudbe(posudba, clan);
		
		ulazni.close();	
		
	}
	
	private static Knjiga unesiKnjigu(int kolikoKnjiga, Scanner ulazni) {
			
			System.out.println("Unos " + (kolikoKnjiga + 1) + ". knjige:");
			
			System.out.println("Molimo, unesite naslov knjige >>");
			String naslovKnjige = ulazni.nextLine();
			
			System.out.println("Molimo, unesite jezik >>");
			String jezikKnjige = ulazni.nextLine();
			
			System.out.println("Molimo, unesite izdavaèa >>");
			String izdavacKnjige = ulazni.nextLine();
			
			System.out.println("Molimo, unesite državu  >>");
			String drzavaKnjige = ulazni.nextLine();
			
			Izdavac izdavac = new Izdavac(izdavacKnjige, drzavaKnjige);
			
			return new Knjiga(naslovKnjige, jezikKnjige, izdavac);
			
			//System.out.println("Unijeli ste knjigu " + naslovKnjige + " na jeziku " + 
			// jezikKnjige + " izdavac je " + izdavacKnjige + " a država izdanja je "+ 
			// drzavaKnjige);
	}
	
	private static Clan unosClana(Scanner ulazni) {
		
		System.out.println("Unos èlana:");
		
		System.out.println("Molimo, unesite OIB èlana >>");
		String oibClana = ulazni.nextLine();
		
		System.out.println("Molimo, unesite ime èlana >>");
		String imeClana = ulazni.nextLine();
		
		System.out.println("Molimo, unesite prezime èlana >>");
		String prezimeClana = ulazni.nextLine();
		
		return new Clan(imeClana, prezimeClana, oibClana);
		
		//System.out.println("Unijeli ste clana sa OIB-om " + oibClana + " imenom " + imeClana 
		// + " i prezimenom " + prezimeClana);	
	}
	
	private static Posudba odaberiKnjigu(Knjiga knjiga[], Clan clan, Scanner ulazni) {
		
		System.out.println("Molimo, odaberite knjigu:");
		
			for (int i = 0; i < 2; i++) {
		
				System.out.println((i+1) + ")" + knjiga[i].getNazivKnjige());
				
			}
			
			LocalDateTime datumPosudbe = LocalDateTime.now();
			
			
			int brojKnjige = ulazni.nextInt();
			
			if (brojKnjige ==1 | brojKnjige == 2) {
				
				return new Posudba(clan, knjiga[brojKnjige - 1], datumPosudbe);
			}
			else {
				
				System.out.println("Ta knjiga ne postoji!");
				
				return odaberiKnjigu(knjiga, clan, ulazni);
			}
	}
	
	private static void stanjePosudbe(Posudba posudba, Clan clan) {
		
		System.out.println("Stanje posudbe:");
		
		System.out.println("Naziv knjige: " + posudba.getNekaKnjiga().getNazivKnjige());
		
		System.out.println("Jezik knjige: " + posudba.getNekaKnjiga().getJezikKnjige());
		
		System.out.println("Izdavaè: " + 
							posudba.getNekaKnjiga().getIzdavacKnjige().getNazivIzdavaca());
		
		System.out.println("Država izdavaèa: " + 
							posudba.getNekaKnjiga().getIzdavacKnjige().getDrzavaIzdavaca());
		
		System.out.println("Podaci korisnika: ");
		
		System.out.println("Prezime: " + clan.getPrezimeClana());
		
		System.out.println("Ime: " + clan.getImeClana());
		
		System.out.println("OIB: " + clan.getOibClana());
		
		DateTimeFormatter formaterDatuma = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		
		System.out.println("Datum posudbe: " + 
							posudba.getDatumPosudbe().format(formaterDatuma));
			
	}

}
